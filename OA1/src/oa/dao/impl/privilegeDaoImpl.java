package oa.dao.impl;

import java.util.List;
import oa.base.BaseDaoImpl;
import oa.dao.IPrivilegeDao;
import oa.domain.privilege;
/**
 * Ȩ�޹���
 * @author ��Զϲ������ɯ
 *
 */
public class privilegeDaoImpl  extends BaseDaoImpl<privilege> implements IPrivilegeDao {
/**
 * ��ѯ����Ȩ���б�
 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<privilege> findTopList() {
		// TODO Auto-generated method stub
String hql = "FROM Privilege p WHERE p.parent IS NULL";
	return this.getSession().createQuery(hql).list();
	}
/**
 * ��ѯ����Ȩ�޶�Ӧ��URL
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllUrl() {
		// TODO Auto-generated method stub
		String hql = "SELECT url FROM Privilege WHERE url IS NOT NULL";
		return this.getSession().createQuery(hql).list();
	}

}
