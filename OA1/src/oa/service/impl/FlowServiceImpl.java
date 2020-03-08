package oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.jbpm.api.ProcessEngine;
import org.jbpm.pvm.internal.wire.binding.ProcessEngineRefBinding;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import oa.dao.IApplicationDao;
import oa.domain.Application;
import oa.domain.ApproveInfo;
import oa.domain.Book;
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
@Override
public void submit(Application app) {
	// ����һ�������¼
	applicationDao.save(app);
	
	// ����һ������ʵ��
	Map<String,Application>map=new HashMap<String, Application>();
	
}
@Override
public List<TaskView> findTaskList(User currentUser) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void approve(ApproveInfo ai, String taskId) {
	// TODO Auto-generated method stub
	
}

/**
 * �ύ����
 */



}
