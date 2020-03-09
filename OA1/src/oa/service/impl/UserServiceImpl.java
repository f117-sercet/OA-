package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import oa.dao.IUserDao;
import oa.domain.PageBean;
import oa.domain.User;
import oa.service.IUserService;
import oa.util.HQLHelper;
import oa.util.MD5Utils;
/**
 * 用户管理
 * @author 永远喜欢亚莉莎
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
  @Resource
  private  IUserDao userDao;
  /**
	 * 查询所有用户列表
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return  userDao.findAll();
	}
	/**
	 * 根据id删除用户
	 */
	@Override
	public void delete(User model) {
		userDao.delete(model.getId());
		
	}

	@Override
	public void save(User model) {
		model.setPassword(MD5Utils.md5("1234"));//为新用户指定默认密码
		userDao.save(model);
		
	}
	/**
	 * 根据id查询用户
	 */
	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}
	/**
	 * 根据id修改用户
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}
		
	/**
	 * 根据登录名查询
	 */

	@Override
	public int findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDao.findByLoginName(loginName);
	}
	/**
	 * 用户登录
	 */
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		return userDao.login(model);
	}
	/**
	 * 分页查询
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return userDao.getPageBean(hh, currentPage);
	}

}
