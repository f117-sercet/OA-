package oa.dao;

import oa.base.IBaseDao;
import oa.domain.User;

public interface IUserDao extends IBaseDao<User>  {

	public int findByLoginName(String loginName);

	public User login(User model);

}
