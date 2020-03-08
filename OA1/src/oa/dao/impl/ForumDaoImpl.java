package oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IForumDao;
import oa.domain.Forum;
/**
 * ���������
 * @author ��Զϲ������ɯ
 *
 */
@Repository

public class ForumDaoImpl extends BaseDaoImpl<Forum> implements IForumDao {
	/**
	 * ��ѯ����б�����position���Խ�������
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		return this.getSession().createQuery(hql).list();

}
}
