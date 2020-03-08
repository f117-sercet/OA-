package oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IApplicationDao;
import oa.domain.Application;
import oa.domain.PageBean;
import oa.service.IApplicationService;
import oa.util.HQLHelper;
/**
 * 申请实体操作
 * @author 永远喜欢亚莉莎
 *
 */
@Service
@Transactional
public class ApplicationServiceImpl implements IApplicationService{
	
	@Resource
	private IApplicationDao applicationDao;
	
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		// TODO Auto-generated method stub
		return  applicationDao.getPageBean(hh, currentPage);
	}
      /**
       * 根据申请的id获取当前申请对应的文件输入流
       */
	@Override
	public InputStream getInputStreamById(Long applicationId) {
	    Application application=applicationDao.getById(applicationId);
		String filePath=application.getFilePath();
        InputStream in=null;
        try {
			in=new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          return in;
	          
	}

	@Override
	public Application getById(Long applicationId) {
		// TODO Auto-generated method stub
		return applicationDao.getById(applicationId);
		
	}

}
