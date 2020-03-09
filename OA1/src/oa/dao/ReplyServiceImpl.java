package oa.dao;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.domain.Forum;
import oa.domain.PageBean;
import oa.domain.Reply;
import oa.domain.Topic;
import oa.service.IReplyService;
import oa.util.HQLHelper;



/**
 * �ظ�����
 * @author ��Զϲ������ɯ
 * 
 *
 */
@Service
@Transactional
public class ReplyServiceImpl  implements IReplyService {

	@Resource
	private IReplyDao replyDao;
	/**
	 * ����ظ�
	 */
	@Override
	public void save(Reply model) {
replyDao.save(model);
		
		Forum forum = model.getTopic().getForum();//�־ö���
		forum.setArticleCount(forum.getArticleCount() + 1);//��������������1
		Topic topic = model.getTopic();//�־ö���
		topic.setLastUpdateTime(model.getPostTime());//�ظ���Ӧ�������������ʱ��Ϊ�ظ�ʱ��
		topic.setLastReply(model);//��������һ���ظ�Ϊ��ǰ�ظ�
		topic.setReplyCount(topic.getReplyCount() + 1);//�ظ�������1
	}
    /**
     * ���������ѯ��Ӧ�ûظ��б�
     */
	@Override
	public List<Reply> getReplyByTopic(Topic model) {
		// TODO Auto-generated method stub
		return replyDao.getReplyByTopic(model);
	}
    /**
     * ��ҳ��ѯ
     */
	@Override
	public PageBean getPageBean(int currentPage, Topic model) {
		// TODO Auto-generated method stub
		return replyDao.getPageBean(currentPage,model);
	}
      /**
       * ��ҳ��ѯ
       */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return replyDao.getPageBean(hh, currentPage);
	}

}
