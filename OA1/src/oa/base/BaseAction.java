package oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import oa.domain.User;
import oa.service.IBookService;
import oa.service.IDepartmentService;
import oa.service.IFlowService;
import oa.service.IForumManageService;
import oa.service.IForumService;
import oa.service.IPrivilegeService;
import oa.service.IProcessDefinitionService;
import oa.service.IReplyService;
import oa.service.IRoleService;
import oa.service.ITemplateService;
import oa.service.ITopicService;
import oa.service.IUserService;
/**
 * 通用父类
 * @author 永远喜欢亚莉莎
 */
public class BaseAction<T>  extends ActionSupport implements ModelDriven<T> {

	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	@Resource
	protected IDepartmentService departmentService;
	@Resource
	protected IUserService userService;
	@Resource
	protected IPrivilegeService privilegeService;
	@Resource
	protected IForumManageService forumManageService;
	@Resource
	protected IForumService forumService;
	@Resource
	protected ITopicService topicService;
	@Resource
	protected IReplyService replyService;
	@Resource
	protected ITemplateService templateService;
	@Resource
	protected IProcessDefinitionService processDefinitionService;
	//在构造方法中获得model类型
	public BaseAction(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();//父类Action类型
		Type[] types = type.getActualTypeArguments();
		Class<T> clazz = (Class<T>) types[0];
		try {
			model = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	protected T model;

	public T getModel() {
		return model;
	}
	/**
	 * 获得值栈
	 * @return
	 */
	protected ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
	
	/**
	 * 获得客户端的ip地址
	 */
	public String getIpAddress(){
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	/**
	 * 获得当前登录用户
	 */
	public User getLoginUser(){
		return (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
	}
	
	//--
	protected int currentPage = 1;//属性驱动，当前页码

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
}
