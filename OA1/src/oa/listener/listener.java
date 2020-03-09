package oa.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import oa.domain.privilege;
import oa.service.IPrivilegeService;

/**
 * ��Ŀ����ʱ����Ȩ�����ݵļ�����
 * @author ��Զϲ������ɯ
 *
 */
public class listener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ��ʼ������
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 1 ��ȡspring����
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
				
				// 2��spring�����л�ȡprivilegeService
				IPrivilegeService service = (IPrivilegeService) applicationContext.getBean("privilegeServiceImpl");
				
				// 3ʹ��service��ѯȨ������
				List<privilege> topList = service.findTopList();
				
				// 4��Ȩ�����ݷ���application������
				sce.getServletContext().setAttribute("privilegeTopList", topList);
				
				System.out.println("Ȩ�������Ѿ�����application��������");
				
				//��ѯ����Ҫ����У���Ȩ��URL
				List<String> allUrl = service.findAllUrl();
				sce.getServletContext().setAttribute("allUrl", allUrl);
			}
		
	}


