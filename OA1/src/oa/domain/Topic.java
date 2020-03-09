package oa.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * ����ʵ��
 * @author ��Զϲ������ɯ
 *
 */

public class Topic extends Article{
	private String title;//����
	private Date lastUpdateTime;//������ʱ��
	private int type;// ��������  0��ʾ��ͨ�� 1��ʾ������ 2��ʾ�ö���
	private Forum forum;// ��ǰ���������ĸ����
	private Set<Reply> replies = new HashSet<Reply>();// ��ǰ�����Ӧ�Ļظ�����
	private int replyCount;//��ǰ�����Ӧ�Ļظ�����
	private Reply lastReply;//��ǰ�����Ӧ�����һ���ظ�
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public Reply getLastReply() {
		return lastReply;
	}
	public void setLastReply(Reply lastReply) {
		this.lastReply = lastReply;
	}

}
