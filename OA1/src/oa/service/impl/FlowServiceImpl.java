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
 * 流转方法
 * @author 永远喜欢亚莉莎
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
	// 保存一个申请记录
	applicationDao.save(app);
	
	// 启动一个流程实例
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
 * 提交申请
 */



}
