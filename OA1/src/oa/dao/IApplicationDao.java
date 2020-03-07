package oa.dao;

import java.util.List;

import oa.base.IBaseDao;
import oa.domain.ApproveInfo;



public interface IApplicationDao extends IBaseDao<ApproveInfo>{

	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId);

}