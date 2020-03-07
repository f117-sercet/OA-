package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

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
public List<ApproveInfo>findApproveInfoisByApplicationId(Long applicationId){
	String hql="FROM ApproveInfo ai WHERE ai.application.id = ? ORDER BY ai.approveTime ASC";
	Query query=this.getSession.createQuery(hql);
	query.setParameter(0, applicationId);
	return query.list();
}

}
