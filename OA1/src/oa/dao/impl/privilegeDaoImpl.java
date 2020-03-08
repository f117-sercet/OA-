package oa.dao.impl;

import java.util.List;
import oa.base.BaseDaoImpl;
import oa.dao.IPrivilegeDao;
import oa.domain.privilege;
/**
 * 权限管理
 * @author 永远喜欢亚莉莎
 *
 */
public class privilegeDaoImpl  extends BaseDaoImpl<privilege> implements IPrivilegeDao {
/**
 * 查询顶级权限列表
 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<privilege> findTopList() {
		// TODO Auto-generated method stub
String hql = "FROM Privilege p WHERE p.parent IS NULL";
	return this.getSession().createQuery(hql).list();
	}
/**
 * 查询所有权限对应的URL
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllUrl() {
		// TODO Auto-generated method stub
		String hql = "SELECT url FROM Privilege WHERE url IS NOT NULL";
		return this.getSession().createQuery(hql).list();
	}

}
