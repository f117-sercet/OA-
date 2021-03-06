package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.IApproveInfoDao;
import oa.domain.ApproveInfo;

/**
 * 审批操作
 * @author 永远喜欢亚莉莎
 *
 */
@Repository
public class ApproveInfoDaoImpl extends BaseDaoImpl<ApproveInfo> implements IApproveInfoDao{
	
/**
 * 根据申请的id查询审批集合
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
