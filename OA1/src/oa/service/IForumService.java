package oa.service;

import java.util.List;

import oa.domain.Forum;
import oa.domain.PageBean;
import oa.util.HQLHelper;



public interface IForumService {
	public List<Forum> findAll();

	public Forum getById(Long id);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
