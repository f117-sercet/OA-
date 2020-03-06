package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.domain.Role;
import oa.service.IRoleService;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Resource
	private  IRoleService  roleService;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleService.findAll();
	}

	@Override
	public void delete(Role model) {
		// TODO Auto-generated method stub
        roleService.delete(model.getId());
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleService.getById(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
   roleService.update(role);
	}

	@Override
	public void save(Role model) {
		// TODO Auto-generated method stub
          roleService.save(model);
	}

}
