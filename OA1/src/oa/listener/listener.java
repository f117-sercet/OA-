package oa.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import oa.domain.privilege;
import oa.service.IPrivilegeService;

/**
 * 项目启动时加载权限数据的监听器
 * @author 永远喜欢亚莉莎
 *
 */
public class listener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 初始化方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 1 获取spring容器
				WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
				
				// 2从spring容器中获取privilegeService
				IPrivilegeService service = (IPrivilegeService) applicationContext.getBean("privilegeServiceImpl");
				
				// 3使用service查询权限数据
				List<privilege> topList = service.findTopList();
				
				// 4将权限数据放入application作用域
				sce.getServletContext().setAttribute("privilegeTopList", topList);
				
				System.out.println("权限数据已经放入application作用域了");
				
				//查询所有要进行校验的权限URL
				List<String> allUrl = service.findAllUrl();
				sce.getServletContext().setAttribute("allUrl", allUrl);
			}
		
	}


