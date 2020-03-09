package oa.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;
import oa.base.BaseAction;
import oa.domain.Role;
import oa.domain.privilege;

/**
 * ��λ����
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class RoleAction  extends BaseAction<Role>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long[] privilegeIds;//��������������Ȩ�޵�id
	
	/**
	 * ��ѯ��λ�б�
	 */
	public String list(){
		List<Role> list = roleService.findAll();
		
		ValueStack vs = getValueStack();
		
		vs.set("list", list);
		
		return "list";
	}
	
	/**
	 * ����idɾ����λ
	 */
	public String delete(){
		roleService.delete(model);
		
		return "toList";
	}
	
	/**
	 * ��ת���޸�ҳ��
	 */
	public String editUI(){
		//����id��ѯ��λ�����ڻ���
		Role role = roleService.getById(model.getId());
		
		getValueStack().push(role);
		
		return "editUI";
	}
	
	/**
	 * �޸ĸ�λ
	 */
	public String edit(){
		//�Ȳ�ѯ�����޸�
		Role role = roleService.getById(model.getId());
		
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		
		return "toList";
	}
	
	/**
	 * ��ת�����ҳ��
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * ��Ӹ�λ
	 */
	public String add(){
		roleService.save(model);
		
		return "toList";
	}
	
	/**
	 * ��ת������Ȩ��ҳ��
	 */
	public String setPrivilegeUI(){
		//1 ����id��ѯ��ǰҪ���õĽ�ɫ�����ڻ���
		Role role = roleService.getById(model.getId());
		getValueStack().push(role);
		
		//2 ��ѯ����Ȩ�����ݣ���ҳ��չʾ
		//List<Privilege> privilegeList = privilegeService.findAll();
		List<privilege> privilegeList = privilegeService.findTopList();//��ѯ����Ȩ��
		getValueStack().set("privilegeList", privilegeList);
		
		//3 ��ѯ��ǰ��ɫ��Ӧ��Ȩ�ޣ�����ҳ�����
		Set<privilege> privileges = role.getPrivileges();
		if(privileges != null && privileges.size() > 0){
			privilegeIds = new Long[privileges.size()];
			int index = 0;
			for(privilege p : privileges){
				privilegeIds[index++] = p.getId();
			}
		}
		
		return "setPrivilegeUI";
	}
	
	/**
	 * Ϊ��ɫ����Ȩ��
	 */
	public String setPrivilege(){
		//�Ȳ�ѯ�����޸�
		Role role = roleService.getById(model.getId());
		
		if(privilegeIds != null && privilegeIds.length > 0){
			//���Ȩ��id���鲻Ϊ�գ��͸���Ȩ��id�����ѯ��Ӧ�Ķ��Ȩ��
			List<privilege> priviList = privilegeService.getByIds(privilegeIds);
			role.setPrivileges(new HashSet<privilege>(priviList));
		}else{
			//���û�������κ�Ȩ�ޣ�����ս�ɫ��Ӧ��Ȩ��
			role.setPrivileges(null);
		}
		
		roleService.update(role);
		
		return "toList";
	}

	public void setPrivilegeIds(Long[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

	public Long[] getPrivilegeIds() {
		return privilegeIds;
	}
	
}


