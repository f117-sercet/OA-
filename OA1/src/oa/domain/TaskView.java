package oa.domain;

import org.jbpm.api.task.Task;



/**
 * 包装申请和信息
 * @author 永远喜欢亚莉莎
 *
 */

public class TaskView {
	private Application application;
	private Task task;
	public TaskView() {}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}

	
}
