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
 * ��������
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class ApproveInfoServiceImpl  implements IApproveInfoService {
     @Resource
     private IApproveInfoDao approveInfoDao;
     /**
      * ��������id��ѯ��Ӧ����������
      */
	@Override
	public List<ApproveInfo> findApproveInfoListByApplicationId(Long applicationId) {
		// TODO Auto-generated method stub
		return  approveInfoDao.findApproveInfoListByApplicationId(applicationId);
	}

}
