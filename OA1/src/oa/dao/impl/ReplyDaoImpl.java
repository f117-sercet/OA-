package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IReplyDao;
import oa.domain.PageBean;
import oa.domain.Reply;
import oa.domain.Topic;

/**
 * 恢复操作
 * @author 永远喜欢亚莉莎
 *
 */

@Repository
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao {
	/**
	 * 根据主题查询对应的回复列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Reply> getReplyByTopic(Topic model) {
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}
/**
 * /**
	 * 分页查询
	 */
 
	@Override
	public PageBean getPageBean(int currentPage, Topic model) {
		// TODO Auto-generated method stub
		
	 int pageSize = 10;
		int firstResult = (currentPage - 1) * pageSize;
		String hql = "FROM Reply r WHERE r.topic = ? ORDER BY r.postTime ASC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List recordList = query.list();
		
		hql = "SELECT COUNT(id) FROM Reply r WHERE r.topic = ?";
		query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		Long recordCount = (Long) query.uniqueResult();
		return new PageBean(currentPage, pageSize, recordCount.intValue(), recordList);
	}

}
