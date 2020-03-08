package oa.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import oa.base.BaseDaoImpl;
import oa.dao.IUserDao;
import oa.domain.User;
import oa.util.MD5Utils;
/**
 * 用户管理
 * @author 永远喜欢亚莉莎
 *
 */
@Repository
public class UserDaoIqmpl extends BaseDaoImpl<User> implements IUserDao {
/**
 * 根据登录名统计
 */
	@Override
	public int findByLoginName(String loginName) {
		String hql = "SELECT COUNT(id) FROM User u WHERE u.loginName = ?";
		Long count = (Long) this.getSession().createQuery(hql).setParameter(0, loginName).uniqueResult();
		return count.intValue();
	}
   /**
    * 用户登录
    */
	@Override
	public User login(User model) {
		String hql = "FROM User u WHERE u.loginName = ? AND u.password = ?";
		Query query = this.getSession().createQuery(hql);
		query.setParameter(0, model.getLoginName());
		query.setParameter(1, MD5Utils.md5(model.getPassword()));
		List<User> list = query.list();
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
