package oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * 权限实体
 * @author 永远喜欢亚莉莎
 *
 */
public class privilege {
	private Long id;
	private String name;//权限的名称
	private String url;//权限对应的请求URL
	private privilege parent;//上级权限
	private Set<privilege> children = new HashSet<privilege>();//下级权限
	private Set<Role> roles = new HashSet<Role>();//当前权限对应的角色集合
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public privilege getParent() {
		return parent;
	}
	public void setParent(privilege parent) {
		this.parent = parent;
	}
	public Set<privilege> getChildren() {
		return children;
	}
	public void setChildren(Set<privilege> children) {
		this.children = children;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


}
