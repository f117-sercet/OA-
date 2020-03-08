package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.ITopicDao;
import oa.domain.Forum;
import oa.domain.Topic;

/**
 * �������
 * @author ��Զϲ������ɯ
 *
 */
@Repository
public class TopicaDaoImpl  extends BaseDaoImpl<Topic> implements ITopicDao{
/**
 *���ݰ���ѯ�����б�
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> findTopicByForum(Forum model) {
		
		String hql = "FROM Topic t WHERE t.forum = ? ORDER BY (CASE t.type WHEN 2 THEN 2 ELSE 1 END) DESC,t.postTime DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model);
		return query.list();
	}

	
}
