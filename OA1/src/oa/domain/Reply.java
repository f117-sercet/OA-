package oa.domain;



/**
 * �ظ�ʵ��
 * @author ��Զϲ������ɯ
 *
 */
public class Reply {
	private Topic topic;//��ǰ�ظ������ĸ�����
	private int deleted;//ɾ����־ 1��ʾ�Ѿ�ɾ�� 0��ʾû��ɾ��
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

}
