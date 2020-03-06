package oa.dao;

import java.util.List;

import oa.base.IBaseDao;
import oa.domain.Department;

public interface IDepartmentDao extends IBaseDao<Department> {
	public List<Department> findTopList();

	public List<Department> findChildren(Long parentId);


}
