package oa.service;

import java.util.List;

import oa.domain.PageBean;
import oa.domain.Reply;
import oa.domain.Topic;
import oa.util.HQLHelper;


public interface IReplyService {

	public void save(Reply model);

	public List<Reply> getReplyByTopic(Topic model);

	public PageBean getPageBean(int currentPage, Topic model);

	public PageBean getPageBean(HQLHelper hh, int currentPage);
}
