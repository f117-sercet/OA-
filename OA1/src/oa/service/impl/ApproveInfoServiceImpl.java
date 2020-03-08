package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IApplicationDao;
import oa.dao.IApproveInfoDao;
import oa.domain.ApproveInfo;
import oa.service.IApproveInfoService;

/**
 * 审批操作
 * @author 永远喜欢亚莉莎
 *
 */
@Service
@Transactional
public class ApproveInfoServiceImpl  implements IApproveInfoService {
     @Resource
     private IApproveInfoDao approveInfoDao;
     /**
      * 根据申请id查询对应的审批集合
      */
	@Override
	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId) {
		// TODO Auto-generated method stub
		return  approveInfoDao.findApproveInfoListByApplicationId(applicationId);
	}

}
