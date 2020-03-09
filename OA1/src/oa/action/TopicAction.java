package oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Forum;
import oa.domain.PageBean;
import oa.domain.Reply;
import oa.domain.Topic;
import oa.util.HQLHelper;



/**
* �������
* @author ��Զϲ������ɯ
*
*/
@Controller
@Scope("prototype")
public class TopicAction extends BaseAction<Topic> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long forumId;//�������������id
	
	
	/**
	 * ��ת����������ҳ��
	 */
	public String addUI(){
		//���ݰ��id��ѯ�����Ϣ������ҳ����ʾ
		Forum forum = forumService.getById(forumId);
		getValueStack().push(forum);
		return "addUI";
	}
	
	/**
	 * ��������
	 */
	public String add(){
		Forum forum = forumService.getById(forumId);
		model.setForum(forum);//����������
		
		model.setIpAddress(getIpAddress());//���ÿͻ��˵�ip��ַ
		model.setPostTime(new Date());//��ǰ����ķ���ʱ��
		model.setLastUpdateTime(model.getPostTime());//����������ʱ��Ϊ���������ʱ��
		model.setReplyCount(0);//���õ�ǰ����Ļظ�����Ϊ0
		model.setType(0);//���������Ϊ��ͨ��
		
		model.setAuthor(getLoginUser());//�������������Ϊ��ǰ��¼�û�
		model.setLastReply(null);//Ĭ��û�лظ�
		
		topicService.save(model);
		
		return "toTopicList";
	}
	
	/**
	 * ��ʾ�������⣨�ظ��б�
	 */
	public String show(){
		//����id��ѯ����
		Topic topic = topicService.getById(model.getId());
		getValueStack().push(topic);
		
		//���������ѯ��Ӧ�Ļظ��б�
		//List<Reply> replyList = replyService.getReplyByTopic(model);
		//getValueStack().set("replyList", replyList);
		
		//PageBean pb = replyService.getPageBean(currentPage,model);
		
		HQLHelper hh = new HQLHelper(Reply.class);
		hh.addWhere("o.topic = ?", model);
		hh.addOrderBy("o.postTime", true);
		PageBean pb = replyService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		
		return "show";
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public Long getForumId() {
		return forumId;
	}
}

	

