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
 * �ָ�����
 * @author ��Զϲ������ɯ
 *
 */

@Repository
public class ReplyDaoImpl extends BaseDaoImpl<Reply> implements IReplyDao {
	/**
	 * ���������ѯ��Ӧ�Ļظ��б�
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
	 * ��ҳ��ѯ
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
