package oa.service;

import java.util.List;

import oa.domain.PageBean;
import oa.domain.User;
import oa.util.HQLHelper;

public interface IUserService {

	public List<User> findAll();

	public void delete(User model);

	public void save(User model);

	public User getById(Long id);

	public void update(User user);

	public int findByLoginName(String loginName);

	public User login(User model);

	public PageBean getPageBean(HQLHelper hh, int currentPage);
	
	
}
