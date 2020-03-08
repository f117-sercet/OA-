package oa.dao;

import java.util.List;

import oa.base.IBaseDao;
import oa.domain.PageBean;
import oa.domain.Reply;
import oa.domain.Topic;

public interface IReplyDao extends IBaseDao<Reply> {
	public List<Reply> getReplyByTopic(Topic model);

	public PageBean getPageBean(int currentPage, Topic model);
	
	

}
