package oa.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import sun.misc.BASE64Encoder;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import oa.domain.Application;
import oa.domain.ApproveInfo;
import oa.domain.PageBean;
import oa.domain.TaskView;
import oa.domain.Template;
import oa.domain.User;
import oa.service.IApplicationService;
import oa.service.IApproveInfoService;
import oa.service.IFlowService;
import oa.service.ITemplateService;
import oa.util.HQLHelper;


/**
 * ��תAction
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class FlowAction  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7400530559336941797L;
	private Long templateId;//����������ģ��id
	private File resource;//�����ļ��ϴ�
	private String status;//����״̬
	private int currentPage = 1;//��ǰҳ��
	private Long applicationId;//���������������id
	private InputStream inputStream;//�����ļ����ص�������
	private String fileName;//�����õ��ļ���
	private String taskId;//����id
	private Boolean approval;//�����Ƿ�ͨ��
	private String comment;//�������
	
	
	@Resource
	private ITemplateService templateService;
	@Resource
	private IFlowService flowService;
	@Resource
	private IApplicationService applicationService;
	@Resource
	private IApproveInfoService approveInfoService;
	
	/**
	 * ������루ģ���б�
	 */
	public String templateList(){
		List<Template> list = templateService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "templateList";
	}
	
	/**
	 * ��ת���ύ����ҳ��
	 */
	public String submitUI(){
		return "submitUI";
	}
	
	/**
	 * �ύ����
	 */
	public String submit(){
		Template template = templateService.getById(templateId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//�����ϴ��ļ�
		String filePath = uploadFile(resource);
		
		//����һ�������¼
		Application app = new Application();
		String title = template.getName() + "_" + getCurrentUser().getName() + "_" + sdf.format(new Date());
		app.setTitle(title);//����ı��� ---{ģ������}_{����������}_{����}
		app.setStatus(Application.STATUS_RUNNING);//�����״̬
		app.setApplyTime(new Date());//����ʱ��
		app.setFilePath(filePath);//�ļ��洢·��
		app.setTemplate(template);//ʹ�õ�ģ��
		app.setApplicant(getCurrentUser());//������
		
		flowService.submit(app);
		
		return "toMyApplicationList";
	}
	
	/**
	 * �ҵ������ѯ�б�
	 */
	public String myApplicationList(){
		//׼������--ģ���б�
		List<Template> list = templateService.findAll();
		ActionContext.getContext().getValueStack().set("templateList", list);
		
		//��ѯ��ҳ����---�ҵ�����
		HQLHelper hh = new HQLHelper(Application.class);
		//��ѯ��ǰ��¼�˵������¼
		hh.addWhere("o.applicant = ?", getCurrentUser());
		
		if(templateId != null){
			//����ģ�����
			hh.addWhere("o.template.id = ?", templateId);
		}
		if(status != null && status.trim().length() > 0){
			//��������״̬����
			hh.addWhere("o.status = ?", status);
		}
		
		//�������---��������ʱ�併��
		hh.addOrderBy("o.applyTime", false);
		
		PageBean pb = applicationService.getPageBean(hh,currentPage);
		
		ActionContext.getContext().getValueStack().push(pb);
		
		return "myApplicationList";
	}
	
	/**
	 *  �鿴������Ϣ�����������ļ���
	 */
	public String download(){
		inputStream = applicationService.getInputStreamById(applicationId);
		
		Application app = applicationService.getById(applicationId);
		fileName = app.getTitle() + ".doc";
		String agent = ServletActionContext.getRequest().getHeader("user-agent");
		try {
			fileName = this.encodeDownloadFilename(fileName, agent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "download";
	}
	
	/**
	 * �鿴��ת��¼��������Ϣ��
	 */
	public String historyApprovedList(){
		//���������id��ѯ��Ӧ�������б�
		List<ApproveInfo> list = approveInfoService.findApproveInfoListByApplicationId(applicationId);
		
		ActionContext.getContext().getValueStack().set("list", list);
		
		return "historyApprovedList";
	}
	
	/**
	 * �����������ҵ������б�
	 */
	public String myTaskList(){
		List<TaskView> list = flowService.findTaskList(getCurrentUser());
		ActionContext.getContext().getValueStack().set("list",list);
		return "myTaskList";
	}
	
	/**
	 * ��ת������ҳ��
	 */
	public String approveUI(){
		return "approveUI";
	}
	
	/**
	 * ��������
	 */
	public String approve(){
		Application application = applicationService.getById(applicationId);
		
		//����һ������ʵ��
		ApproveInfo ai = new ApproveInfo();
		ai.setApplication(application);//���õ�ǰ��������������
		ai.setApproval(approval);//�Ƿ�ͨ��
		ai.setApprover(getCurrentUser());//������
		ai.setApproveTime(new Date());//����ʱ��
		ai.setComment(getComment());//�������
		
		flowService.approve(ai,taskId);
		
		return "toMyTaskList";
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	public Long getTemplateId() {
		return templateId;
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
		file.renameTo(dest);
		return filePath;
	}
	public User getCurrentUser(){
		return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	}
	/**
	 * ��ȡ��ǰ��¼�û�
	 */
	/**
	 * �����ļ�ʱ����Բ�ͬ����������и������ı���
	 * @param filename �����ļ���
	 * @param agent �ͻ��������(ͨ��request.getHeader("user-agent")���)
	 * @return ���������ظ�����
	 * @throws IOException
	 */
	public String encodeDownloadFilename(String filename, String agent) throws IOException{
		if(agent.contains("Firefox")){ // ��������
			filename = "=?UTF-8?B?"+new BASE64Encoder()().encode(filename.getBytes("utf-8"))+"?=";
		}else{ // IE�����������
			filename = URLEncoder.encode(filename,"utf-8");
		}
		return filename;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public File getResource() {
		return resource;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}
}
