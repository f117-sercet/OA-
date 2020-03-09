package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IPrivilegeDao;
import oa.domain.privilege;
import oa.service.IPrivilegeService;

/**
 * 权限管理
 * @author 永远喜欢亚莉莎

 *
 */
@Service
@Transactional
public class privilegdeServiceImpl implements IPrivilegeService {
@Resource
private  IPrivilegeDao  privilegeDao;
/**
 * 查询所有权限列表	
 * @return
 */
@Override
	public List<privilege> findAll() {
	
		return privilegeDao.findAll();
	}
/**
 *  根据id数组查询多个权限
 */
	@Override
	public List<privilege> getByIds(Long[] privilegeIds) {
		// TODO Auto-generated method stub
		return privilegeDao.getByIds(privilegeIds);
	}
  /**
   * 查询顶级权限列表
   */
	@Override
	public List<privilege> findTopList() {
		// TODO Auto-generated method stub
		return privilegeDao.findTopList();
	}
     /**
      * 查询所有权限对应的URL
      */
	@Override
	public List<String> findAllUrl() {
		// TODO Auto-generated method stub
		return privilegeDao.findAllUrl();

}
}
