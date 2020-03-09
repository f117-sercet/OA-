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
 * �û�����
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {
  @Resource
  private  IUserDao userDao;
  /**
	 * ��ѯ�����û��б�
	 */
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return  userDao.findAll();
	}
	/**
	 * ����idɾ���û�
	 */
	@Override
	public void delete(User model) {
		userDao.delete(model.getId());
		
	}

	@Override
	public void save(User model) {
		model.setPassword(MD5Utils.md5("1234"));//Ϊ���û�ָ��Ĭ������
		userDao.save(model);
		
	}
	/**
	 * ����id��ѯ�û�
	 */
	@Override
	public User getById(Long id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}
	/**
	 * ����id�޸��û�
	 */
	@Override
	public void update(User user) {
		userDao.update(user);
	}
		
	/**
	 * ���ݵ�¼����ѯ
	 */

	@Override
	public int findByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDao.findByLoginName(loginName);
	}
	/**
	 * �û���¼
	 */
	@Override
	public User login(User model) {
		// TODO Auto-generated method stub
		return userDao.login(model);
	}
	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return userDao.getPageBean(hh, currentPage);
	}

}
