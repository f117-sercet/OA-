package oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IDepartmentDao;
import oa.domain.Department;

/**
 * ���Ź���
 * @author ��Զϲ������ɯ
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class DeparmentDaoImpl extends BaseDaoImpl<Department> implements IDepartmentDao{
	/**
	 * ��ѯ���������б�
	 * 
	 */
	public List<Department>findTopList(){
		
		String hql="FROM Department d WHERE d.parent IS NULL";
		return this.getSession().createQuery(hql).list();
	}
 
	 /**
	  * ��ѯָ�����ŵ��Ӳ����б�
	  */
	
	public List<Department>findChildren(Long parentId){
		String hql = "FROM Department d WHERE d.parent.id = ?";
		return this.getSession().createQuery(hql).setParameter(0, parentId).list();
		
	}
}
