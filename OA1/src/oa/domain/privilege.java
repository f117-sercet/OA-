package oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * Ȩ��ʵ��
 * @author ��Զϲ������ɯ
 *
 */
public class privilege {
	private Long id;
	private String name;//Ȩ�޵�����
	private String url;//Ȩ�޶�Ӧ������URL
	private privilege parent;//�ϼ�Ȩ��
	private Set<privilege> children = new HashSet<privilege>();//�¼�Ȩ��
	private Set<Role> roles = new HashSet<Role>();//��ǰȨ�޶�Ӧ�Ľ�ɫ����
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
