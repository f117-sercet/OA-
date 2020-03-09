package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IPrivilegeDao;
import oa.domain.privilege;
import oa.service.IPrivilegeService;

/**
 * Ȩ�޹���
 * @author ��Զϲ������ɯ

 *
 */
@Service
@Transactional
public class privilegdeServiceImpl implements IPrivilegeService {
@Resource
private  IPrivilegeDao  privilegeDao;
/**
 * ��ѯ����Ȩ���б�	
 * @return
 */
@Override
	public List<privilege> findAll() {
	
		return privilegeDao.findAll();
	}
/**
 *  ����id�����ѯ���Ȩ��
 */
	@Override
	public List<privilege> getByIds(Long[] privilegeIds) {
		// TODO Auto-generated method stub
		return privilegeDao.getByIds(privilegeIds);
	}
  /**
   * ��ѯ����Ȩ���б�
   */
	@Override
	public List<privilege> findTopList() {
		// TODO Auto-generated method stub
		return privilegeDao.findTopList();
	}
     /**
      * ��ѯ����Ȩ�޶�Ӧ��URL
      */
	@Override
	public List<String> findAllUrl() {
		// TODO Auto-generated method stub
		return privilegeDao.findAllUrl();

}
}
