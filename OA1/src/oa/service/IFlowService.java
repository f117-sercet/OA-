package oa.service;

import java.util.List;

import oa.domain.Application;
import oa.domain.ApproveInfo;
import oa.domain.TaskView;
import oa.domain.User;


public interface IFlowService {


	public void submit(Application app);

	public List<TaskView> findTaskList(User currentUser);

	public void approve(ApproveInfo ai, String taskId);
}
