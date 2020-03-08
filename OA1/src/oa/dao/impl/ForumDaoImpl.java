package oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IForumDao;
import oa.domain.Forum;
/**
 * 参与板块操作
 * @author 永远喜欢亚莉莎
 *
 */
@Repository

public class ForumDaoImpl extends BaseDaoImpl<Forum> implements IForumDao {
	/**
	 * 查询板块列表，按照position属性进行排序
	 */
	@SuppressWarnings("unchecked")
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		return this.getSession().createQuery(hql).list();

}
}
