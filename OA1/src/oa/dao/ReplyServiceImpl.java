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
 * 回复操作
 * @author 永远喜欢亚莉莎
 * 
 *
 */
@Service
@Transactional
public class ReplyServiceImpl  implements IReplyService {

	@Resource
	private IReplyDao replyDao;
	/**
	 * 发表回复
	 */
	@Override
	public void save(Reply model) {
replyDao.save(model);
		
		Forum forum = model.getTopic().getForum();//持久对象
		forum.setArticleCount(forum.getArticleCount() + 1);//版块的文章数量加1
		Topic topic = model.getTopic();//持久对象
		topic.setLastUpdateTime(model.getPostTime());//回复对应的主题的最后更新时间为回复时间
		topic.setLastReply(model);//主题的最后一个回复为当前回复
		topic.setReplyCount(topic.getReplyCount() + 1);//回复数量加1
	}
    /**
     * 根据主题查询对应得回复列表
     */
	@Override
	public List<Reply> getReplyByTopic(Topic model) {
		// TODO Auto-generated method stub
		return replyDao.getReplyByTopic(model);
	}
    /**
     * 分页查询
     */
	@Override
	public PageBean getPageBean(int currentPage, Topic model) {
		// TODO Auto-generated method stub
		return replyDao.getPageBean(currentPage,model);
	}
      /**
       * 分页查询
       */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return replyDao.getPageBean(hh, currentPage);
	}

}
