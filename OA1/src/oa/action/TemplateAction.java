package oa.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Template;


/**
 * ģ�����
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class TemplateAction extends  BaseAction<Template> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File resource;//�����ļ��ϴ�
	private InputStream downloadFile;//�����ļ����ص�������
	private String fileName;//����ʱ���ļ���
	
	/**
	 * ��ѯģ���б�
	 */
	public String list(){
		List<Template> list = templateService.findAll();
		getValueStack().set("list", list);
		return "list";
	}
	
	/**
	 * ����idɾ��ģ��
	 */
	public String delete(){
		templateService.delete(model.getId());
		
		return "toList";
	}
	
	/**
	 * ��ת���޸�ҳ��
	 */
	public String editUI(){
		//����id��ѯģ���������ҳ�����
		Template template = templateService.getById(model.getId());
		getValueStack().push(template);
		
		//��ѯ���̶����б�,��������������������б�
		List<ProcessDefinition> pdList = processDefinitionService.findLastList();
		getValueStack().set("pdList", pdList);
		return "editUI";
	}
	
	/**
	 * �޸�ģ��
	 */
	public String edit(){
		//�Ȳ�ѯ�����޸�
		Template template = templateService.getById(model.getId());
		template.setName(model.getName());
		template.setProcessDefinitionKey(model.getProcessDefinitionKey());
		
		if(resource != null){
			//�û��ϴ������ļ�
			String filePath = uploadFile(resource);//�ϴ��ļ������ҷ����ϴ����ļ�·��
			
			//ɾ��ԭ�����ļ�
			String path = template.getFilePath();
			File file = new File(path);
			if(file.exists()){
				file.delete();
			}
			template.setFilePath(filePath);//�����������ļ�·��
		}
		
		templateService.update(template);
		
		return "toList";
	}

	/**
	 * ��ת�����ģ��ҳ��
	 */
	public String addUI(){
		//׼������----���̶����б�
		List<ProcessDefinition> pdList = processDefinitionService.findLastList();
		getValueStack().set("pdList", pdList);
		
		return "addUI";
	}
	
	/**
	 * ���ģ��
	 */
	public String add(){
		//���ϴ����ļ�������uploadFilesĿ¼��
		String filePath = uploadFile(resource);
		model.setFilePath(filePath);
		templateService.save(model);
		return "toList";
	}
	
	/**
	 * ����ģ���Ӧ���ļ�
	 */
	public String download(){
		downloadFile = templateService.getInputStreamById(model.getId());
		
		Template template = templateService.getById(model.getId());
		
		String agent = ServletActionContext.getRequest().getHeader("user-agent");
		try {
			fileName = encodeDownloadFilename(template.getName() + ".doc", agent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "download";
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public File getResource() {
		return resource;
	}
	
	/**
	 * �ϴ��ļ� 
	 * @param file
	 * @return
	 */
	public String uploadFile(File file){
		String realPath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/uploadFiles");
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");
		String dateStr = sdf.format(new Date());
		dateStr = realPath + dateStr;
		File dateFile = new File(dateStr);
		
		if(!dateFile.exists()){
			dateFile.mkdirs();
		}
		
		String filePath = dateStr + UUID.randomUUID().toString() + ".doc";
		File dest = new File(filePath);
		resource.renameTo(dest);
		return filePath;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public InputStream getDownloadFile() {
		return downloadFile;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
	
	/**
	 * �����ļ�ʱ����Բ�ͬ����������и������ı���
	 * @param filename �����ļ���
	 * @param agent �ͻ��������(ͨ��request.getHeader("user-agent")���)
	 * @return ���������ظ�����
	 * @throws IOException
	 */
	public String encodeDownloadFilename(String filename, String agent) throws IOException{
		if(agent.contains("Firefox")){ // ��������
			filename = "=?UTF-8?B?"+new BASE64Encoder().encode(filename.getBytes("utf-8"))+"?=";
		}else{ // IE�����������
			filename = URLEncoder.encode(filename,"utf-8");
		}
		return filename;
	}
}

