package oa.domain;

import java.util.HashSet;
import java.util.Set;

import cn.itcast.oa.domain.Privilege;
import cn.itcast.oa.domain.Role;
/**
 * �û�ʵ��
 * @author ��Զϲ������ɯ
 *
 */
public class User {
	private Long id;
	private String loginName;
	private String name;
	private int gender;
	private String phone;
	private String email;
	private String description;
	private String password;
	private Department department;
	private Set<Role> roles = new HashSet<Role>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * �жϵ�ǰ�û��Ƿ��и�����Ȩ��url
	 */
	public boolean hasPrivilegeByUrl(String url) {
		//�����¼�û��ǳ�������Ա����ֱ�ӷ���true
		if(isAdmin()){
			return true;
		}
		
		//������ǰ�û�����Ľ�ɫ
		for(Role role : roles){
			Set<Privilege> privileges = role.getPrivileges();
			//������ɫ��Ӧ��Ȩ�޼���
			for(Privilege p : privileges){
				String pUrl = p.getUrl();
				if(url.equals(pUrl)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * �жϵ�ǰ�û��Ƿ��ǳ�������Ա
	 */
	public boolean isAdmin(){
		return "admin".equals(loginName);
	}
}
