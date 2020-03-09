package oa.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IRoleDao;
import oa.domain.Role;
import oa.service.IRoleService;
/**
 * ∏⁄Œªπ‹¿Ì
 * @author ”¿‘∂œ≤ª∂—«¿Ú…Ø
 *
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Resource
	private  IRoleDao  roleDao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void delete(Role model) {
		// TODO Auto-generated method stub
        roleDao.delete(model.getId());
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
         roleDao.update(role);
	}

	@Override
	public void save(Role model) {
		// TODO Auto-generated method stub
          roleDao.save(model);
	}

}
