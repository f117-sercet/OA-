package oa.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import oa.base.BaseAction;
import oa.domain.Department;
import oa.domain.PageBean;
import oa.domain.Role;
import oa.domain.User;
import oa.util.DepartmentUtils;
import oa.util.HQLHelper;
import oa.util.MD5Utils;

/**
 * �û�����
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long departmentId;//��������������id
	private Long[] roleIds;//������������λid
	
	/**
	 * ��ѯ�û��б�
	 */
	public String list(){
		/*List<User> list = userService.findAll();
		getValueStack().set("userList", list);*/
		
		HQLHelper hh = new HQLHelper(User.class);//�ڹ��췽����ƴ��FROM ���
		
		PageBean pb = userService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		return "list";
	}
	
	/**
	 * ����idɾ���û�
	 */
	public String delete(){
		userService.delete(model);
		return "toList";
	}
	
	/**
	 * ��ת���û����ҳ��
	 */
	public String addUI(){
		//׼�����ݣ����������б���λ�б�
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleService.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		return "addUI";
	}
	
	/**
	 * ����û�
	 */
	public String add(){
		if(departmentId != null){
			Department dept = departmentService.getById(departmentId);
			model.setDepartment(dept);//�û���������
		}
		
		if(roleIds != null && roleIds.length > 0){
			List<Role> roleList = roleService.getByIds(roleIds);
			model.setRoles(new HashSet<Role>(roleList));
		}
		
		userService.save(model);
		
		return "toList";
	}
	
	/**
	 * ��ת���û��޸�ҳ��
	 */
	public String editUI(){
		User user = userService.getById(model.getId());
		getValueStack().push(user);
		
		//׼�����ݣ����������б���λ�б�
		List<Department> topList = departmentService.findTopList();
		List<Department> treeList = DepartmentUtils.getTreeList(topList, null);
		
		List<Role> roleList = roleService.findAll();
		
		getValueStack().set("treeList", treeList);
		getValueStack().set("roleList", roleList);
		
		if(user.getDepartment() != null){
			//��ѯ�û��������ţ����ڻ���
			departmentId = user.getDepartment().getId();
		}
		
		Set<Role> roles = user.getRoles();
		if(roles != null && roles.size() > 0){
			//��õ�ǰ�޸��û��ĸ�λid�����ڻ���
			int size = roles.size();
			roleIds = new Long[size];
			int c = 0;
			for(Role role : roles){
				roleIds[c++] = role.getId();
			}
		}
		
		return "editUI";
	}
	
	/**
	 * ����id�޸��û�
	 */
	public String edit(){
		//�Ȳ�ѯ�����޸�
		User user = userService.getById(model.getId());
		
		user.setLoginName(model.getLoginName());
		user.setName(model.getName());
		user.setGender(model.getGender());
		user.setPhone(model.getPhone());
		user.setEmail(model.getEmail());
		user.setDescription(model.getDescription());
		
		if(departmentId != null){
			Department dept = departmentService.getById(departmentId);
			user.setDepartment(dept);
		}else{
			user.setDepartment(null);
		}
		
		if(roleIds != null && roleIds.length > 0){
			List<Role> roles = roleService.getByIds(roleIds);
			user.setRoles(new HashSet<Role>(roles));
		}else{
			user.setRoles(null);
		}
		
		userService.update(user);
		
		return "toList";
	}

	/**
	 * ��ʼ������
	 */
	public String intiPassword(){
		//�Ȳ�ѯ
		User user = userService.getById(model.getId());
		user.setPassword(MD5Utils.md5("1234"));//��������Ϊ1234
		
		userService.update(user);
		return "toList";
	}
	
	/**
	 * ��ѯ��ǰ��¼���Ƿ����
	 * @return
	 */
	public String findByLoginName(){
		String loginName = model.getLoginName();
		int count = userService.findByLoginName(loginName);
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		String flag = "1";
		if(count > 0){
			//��ǰ��¼���Ѿ����ڣ�����ʹ��
			flag = "0";
		}
		try {
			ServletActionContext.getResponse().getWriter().print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	/**
	 * �û���¼
	 */
	public String login(){
		User user = userService.login(model);
		
		if(user != null){
			//��¼�ɹ�
			//����¼�û�����Session
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
			return "home";
		}else{
			//��¼ʧ��
			//���ô�����ʾ
			this.addActionError("�û��������������");
			return "loginUI";
		}
	}
	
	/**
	 * �û��˳�ϵͳ
	 */
	public String logout(){
		//��Session�������¼�û�
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		
		//��ת����¼ҳ��
		return "loginUI";
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	public Long[] getRoleIds() {
		return roleIds;
	}
}



