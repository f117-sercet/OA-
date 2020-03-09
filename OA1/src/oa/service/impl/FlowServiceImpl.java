package oa.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.ProcessInstanceQuery;
import org.jbpm.api.TaskQuery;
import org.jbpm.api.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oa.dao.IApplicationDao;
import oa.dao.IApproveInfoDao;
import oa.domain.Application;
import oa.domain.ApproveInfo;
import oa.domain.TaskView;
import oa.domain.User;
import oa.service.IFlowService;


/**
 * ��ת����
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class FlowServiceImpl implements IFlowService{
	
@Resource
private IApplicationDao applicationDao;
@Resource
private ProcessEngine  processEngine;
@Resource
private IApproveInfoDao approveInfoDao;
@Override
public void submit(Application app) {
	// ����һ�������¼
	applicationDao.save(app);
	
	// ����һ������ʵ��
	Map<String,Application>map=new HashMap<String, Application>();
	map.put("application", app);
	ProcessInstance pi=processEngine.getExecutionService().startProcessInstanceByKey(app.getTemplate().getProcessDefinitionKey(),map);
	//�����ύ�����ҵ��
 TaskQuery query=processEngine.getTaskService().createTaskQuery();
 query.processInstanceId(pi.getId());//��ȡ��ǰ����ʵ����Ψһ��һ������
  Task task=query.uniqueResult();
  
  String taskId=task.getId();
  processEngine.getTaskService().completeTask(taskId);
}
/**
 * ��ѯ�ҵ�����
 */
@Override
public List<TaskView> findTaskList(User currentUser) {
	// �����û���¼����ѯ��Ӧ�������б�
	List<Task> taskList =processEngine.getTaskService().findPersonalTasks(currentUser.getLoginName());
	List<TaskView>list=new ArrayList<TaskView>();
	//�����̱����л�ȡ��Ӧ��һ������ʵ��
	for(Task task : taskList){
		Application application = (Application) processEngine.getTaskService().getVariable(task.getId(), "application");
		TaskView tv = new TaskView(application,task);
		list.add(tv);
	}
	return list;
}
/**
 * ��������
 */
@Override
public void approve(ApproveInfo ai, String taskId) {
	// TODO Auto-generated method stub
	Task task=processEngine.getTaskService().getTask(taskId);//��������id��ѯ����
     String  executionId=task.getExecutionId();//���Id

       //����һ������ʵ��
     
     approveInfoDao.save(ai);
     //��������
     processEngine.getTaskService().completeTask(taskId);
     ProcessInstanceQuery query = processEngine.getExecutionService().createProcessInstanceQuery();
		query.processInstanceId(executionId);//��ӹ�������
		ProcessInstance pi = query.uniqueResult();
  	if(ai.getApproval()){
	//����ͨ��
	if(pi== null){
		//��ǰ�������������һ������
		//����״̬��Ϊ"��ͨ��"
		ai.getApplication().setStatus(Application.STATUS_APPROVED);
	}
	
}else{
	//����״̬��Ϊ"δͨ��"
	ai.getApplication().setStatus(Application.STATUS_UNAPPROVED);
	//������ͨ��
	if(pi != null){
		//���̻�û�н������ֶ�������ǰ����ʵ��
		processEngine.getExecutionService().endProcessInstance(executionId, ProcessInstance.STATE_ENDED);

}
}

}

}
