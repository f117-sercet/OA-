package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.ITopicDao;
import oa.domain.Forum;
import oa.domain.PageBean;
import oa.domain.Topic;
import oa.service.ITopicService;
import oa.util.HQLHelper;

/**
 * �������
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class TopicServiceImpl  implements ITopicService {
	@Resource
	private ITopicDao  topicDao;
	
	@Override
	public List<Topic> findTopicByForum(Forum model) {
		// TODO Auto-generated method stub
		return topicDao.findTopicByForum(model);
	}
	/**
	 * ��������
	 */
	@Override
	public void save(Topic model) {
topicDao.save(model);//modelΪ�־ö���
		
		Forum forum = model.getForum();//forumΪ�־ö���
		
		forum.setTopicCount(forum.getTopicCount() + 1);//��ǰ�������ڰ�������������1
		forum.setArticleCount(forum.getArticleCount() + 1);//��ǰ�������ڰ�������������1
		forum.setLastTopic(model);//���ð�����󷢱������Ϊ��ǰ����
	}
	/**
	 * ����id��ѯ����
	 */
	@Override
	public Topic getById(Long id) {
		// TODO Auto-generated method stub
		return topicDao.getById(id);
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return topicDao.getPageBean(hh, currentPage);
	}

}
