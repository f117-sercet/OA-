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
 * 主题操作
 * @author 永远喜欢亚莉莎
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
	 * 发表主题
	 */
	@Override
	public void save(Topic model) {
topicDao.save(model);//model为持久对象
		
		Forum forum = model.getForum();//forum为持久对象
		
		forum.setTopicCount(forum.getTopicCount() + 1);//当前主题所在版块的主题数量加1
		forum.setArticleCount(forum.getArticleCount() + 1);//当前主题所在版块的文章数量加1
		forum.setLastTopic(model);//设置版块的最后发表的主题为当前主题
	}
	/**
	 * 根据id查询主题
	 */
	@Override
	public Topic getById(Long id) {
		// TODO Auto-generated method stub
		return topicDao.getById(id);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return topicDao.getPageBean(hh, currentPage);
	}

}
