package oa.service;

import java.util.List;

import oa.domain.Forum;
import oa.domain.PageBean;
import oa.domain.Topic;
import oa.util.HQLHelper;

;

public interface ITopicService {

	List<Topic> findTopicByForum(Forum model);

	public void save(Topic model);

	public Topic getById(Long id);

	public PageBean getPageBean(HQLHelper hh, int currentPage);

}
