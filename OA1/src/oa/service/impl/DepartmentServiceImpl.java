package oa.service.impl;

import java.util.List;
/**
 * 部门管理
 */

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IDepartmentDao;
import oa.domain.Department;
import oa.service.IDepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

	@Resource
	private IDepartmentDao departmentDao;
	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void delete(Department model) {
		// TODO Auto-generated method stub
    departmentDao.delete(model.getId());
	}

	@Override
	public Department getById(Long parentId) {
		// TODO Auto-generated method stub
		return departmentDao.getById(parentId);
	}

	@Override
	public void save(Department model) {
		// TODO Auto-generated method stub
		departmentDao.save(model);
	}

	@Override
	public void update(Department dept) {
		// TODO Auto-generated method stub
          departmentDao.update(dept);
	}

	@Override
	public List<Department> findTopList() {
		// TODO Auto-generated method stub
		return departmentDao.findTopList();
	}

	@Override
	public List<Department> findChildren(Long parentId) {
		// TODO Auto-generated method stub
		return departmentDao.findChildren(parentId);
	}

}
