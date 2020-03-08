package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IFourmManageDao;
import oa.domain.Forum;
@Repository
public class ForumManagerDaoIqmpl extends BaseDaoImpl<Forum> implements IFourmManageDao {

	
	/**
	 * 重写查询方法,按照position排序
	 */
	
	@SuppressWarnings("unchecked")
	public List<Forum> findAll() {
		String hql = "FROM Forum f ORDER BY f.position";
		return this.getSession().createQuery(hql).list();
	}
	
	
	
	/**
	 * 重写父类的保存方法，加入保存版块时，设置position的值为id的值
	 */
	public void save(Forum entity) {
		super.save(entity);// 由瞬时对象变为持久对象，id已经有值
		entity.setPosition(entity.getId().intValue());// 设置position的值为id的值
	}
	
	/**
	 * 上移版块
	 */
	@Override
	public void moveUp(Long id) {
		// TODO Auto-generated method stub
		Forum forum1 = getById(id);
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position < ? ORDER BY f.position DESC";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
	}
	/**
	 * 下移版块
	 */
	@Override
	public void moveDown(Long id) {
	
		Forum forum1 = getById(id);
		int p1 = forum1.getPosition();
		
		String hql = "FROM Forum f WHERE f.position > ? ORDER BY f.position";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, p1);
		query.setFirstResult(0);
		query.setMaxResults(1);
		Forum forum2 = (Forum) query.uniqueResult();
		
		forum1.setPosition(forum2.getPosition());
		forum2.setPosition(p1);
	}

}
