package oa.action;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Reply;
import oa.domain.Topic;

/**
 * �ظ�����
 * @author ��Զϲ������ɯ
 *
 */
	@Controller
	@Scope("prototype")
	public class ReplyAction extends BaseAction<Reply>{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 4577425517625309198L;
		private Long topicId;//��������������id
		
		/**
		 * ��ת���ظ�ҳ��
		 */
		public String addUI(){
			Topic topic = topicService.getById(topicId);
			getValueStack().push(topic);
			return "addUI";
		}
		
		/**
		 * ����ظ�
		 */
		public String add(){
			Topic topic = topicService.getById(topicId);
			model.setTopic(topic);//�ظ���������
			
			model.setDeleted(0);//Ĭ��Ϊδɾ��
			model.setIpAddress(getIpAddress());//���ÿͻ��˵�ip��ַ
			model.setPostTime(new Date());//���ûظ�ʱ��Ϊ��ǰʱ��
			model.setAuthor(getLoginUser());//���ûظ���Ϊ��ǰ��¼�û�
			
			replyService.save(model);
			return "toReplyList";//��ת���ظ��б�
		}

		public void setTopicId(Long topicId) {
			this.topicId = topicId;
		}

		public Long getTopicId() {
			return topicId;
		}
	}



