package oa.dao;

import java.util.List;

import oa.base.IBaseDao;
import oa.domain.privilege;

public interface IPrivilege  extends IBaseDao<privilege>{

	public List<privilege> findTopList();

	public List<String> findAllUrl();

}
