package oa.service;

import java.util.List;

import oa.domain.privilege;

public interface IPrivilegeService {
	public List<privilege> findAll();

	public List<privilege> getByIds(Long[] privilegeIds);

	public List<privilege> findTopList();

	public List<String> findAllUrl();
}
