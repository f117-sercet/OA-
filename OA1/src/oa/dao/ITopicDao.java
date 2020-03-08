package oa.dao;

import java.util.List;

import oa.base.IBaseDao;
import oa.domain.Forum;
import oa.domain.Topic;

public interface ITopicDao extends IBaseDao<Topic> {
	public List<Topic> findTopicByForum(Forum model);

}
