package oa.service;

import java.io.InputStream;

import oa.domain.Application;
import oa.domain.PageBean;
import oa.util.HQLHelper;


public interface IApplicationService {

	public PageBean getPageBean(HQLHelper hh, int currentPage);

	public InputStream getInputStreamById(Long applicationId);

	public Application getById(Long applicationId);
}
