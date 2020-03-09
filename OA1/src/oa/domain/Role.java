package oa.domain;

import java.util.HashSet;
import java.util.Set;


/**
 * ∏⁄Œª µÃÂ
 * @author ”¿‘∂œ≤ª∂—«¿Ú…Ø
 *
 */
public class Role {
	
	private Long id;
	private String name;
	private String description;
	private Set<User> users = new HashSet<User>();
	private Set<privilege> privileges = new HashSet<privilege>();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;

}
	public Set<privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<privilege> privileges) {
		this.privileges = privileges;
	}
}