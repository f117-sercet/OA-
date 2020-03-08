package oa.service;

import java.util.List;

import oa.domain.ApproveInfo;

public interface IApproveInfoService {

	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId);
}
