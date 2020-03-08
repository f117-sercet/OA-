package oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IDepartmentDao;
import oa.domain.Department;

/**
 * 部门管理
 * @author 永远喜欢亚莉莎
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class DeparmentDaoImpl extends BaseDaoImpl<Department> implements IDepartmentDao{
	/**
	 * 查询顶级部门列表
	 * 
	 */
	public List<Department>findTopList(){
		
		String hql="FROM Department d WHERE d.parent IS NULL";
		return this.getSession().createQuery(hql).list();
	}
 
	 /**
	  * 查询指定部门的子部门列表
	  */
	
	public List<Department>findChildren(Long parentId){
		String hql = "FROM Department d WHERE d.parent.id = ?";
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
		
	}
}
