package oa.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import oa.service.IProcessDefinitionService;

/**
 * ���̶������
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class ProcessDefinition extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File resource;//�����ļ��ϴ�
	private String key;//�������������̶����key
	private InputStream inputStream;//�����ļ����ص�������
	private String id;//�������������̶����id
	@Resource
	private IProcessDefinitionService processDefinitionService;
	
	/**
	 * ��ѯ���̶����б�
	 */
	public String list(){
		List<ProcessDefinition> list = processDefinitionService.findLastList();
		ActionContext.getContext().getValueStack().set("list", list);
		return "list";
	}
	
	/**
	 * ����keyɾ�����̶���
	 */
	public String delete(){
		try {
			key = new String(key.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		processDefinitionService.deleteByKey(key);
		return "toList";
	}
	
	/**
	 * ��ת�����̶��岿��ҳ��
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * �������̶���
	 */
	public String add(){
		//ʹ���ϴ����ļ����������̶���
		processDefinitionService.deploy(resource);
		return "toList";
	}
	
	/**
	 * ��ѯ����ͼ
	 */
	public String showImage(){
		try {
			id = new String(id.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		inputStream = processDefinitionService.getImageInputStream(id);
		return "showImage";
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public File getResource() {
		return resource;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}


