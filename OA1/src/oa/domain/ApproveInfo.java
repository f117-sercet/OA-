package oa.domain;

import java.util.Date;


/**
 * ����ʵ��
 * @author 60221
 *
 */
public class ApproveInfo {
	private Long id;
	private User approver;//������
	private Date approveTime;//����ʱ��
	private Boolean approval;//�Ƿ�ͨ��
	private String comment;//�������
	private Application application;//����
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getApprover() {
		return approver;
	}
	public void setApprover(User approver) {
		this.approver = approver;
	}
	public Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(Date approveTime) {
		this.approveTime = approveTime;
	}
	public Boolean getApproval() {
		return approval;
	}
	public void setApproval(Boolean approval) {
		this.approval = approval;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	

}
