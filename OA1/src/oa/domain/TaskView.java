package oa.domain;

import org.jbpm.api.task.Task;



/**
 * ��װ�������Ϣ
 * @author ��Զϲ������ɯ
 *
 */

public class TaskView {
	private Application application;
	private Task task;
	public TaskView(Application application,Task task) {
		this.task=task;
		this.application=application;
	}
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
