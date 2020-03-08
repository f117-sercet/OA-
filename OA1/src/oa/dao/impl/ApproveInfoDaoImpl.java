package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IApproveInfoDao;
import oa.domain.ApproveInfo;

/**
 * ��������
 * @author ��Զϲ������ɯ
 *
 */
@Repository
public class ApproveInfoDaoImpl extends BaseDaoImpl<ApproveInfo> implements IApproveInfoDao{
	
/**
 * ���������id��ѯ��������
 */

@SuppressWarnings("unchecked")
@Override
public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId) {
	// TODO Auto-generated method stub
	String hql="FROM ApproveInfo ai WHERE ai.application.id = ? ORDER BY ai.approveTime ASC";
	Query query=this.getSession().createQuery(hql);
	query.setParameter(0, applicationId);
	return query.list();

}

}
