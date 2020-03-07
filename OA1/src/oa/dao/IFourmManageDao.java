package oa.dao;

import oa.base.IBaseDao;
import oa.domain.Forum;

public interface IFourmManageDao extends IBaseDao<Forum> {
	
	public void  moveUp(Long id);

	public void moveDown(Long id);

}
