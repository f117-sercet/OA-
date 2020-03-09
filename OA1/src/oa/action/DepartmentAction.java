package oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import oa.base.BaseAction;
import oa.domain.Department;
import oa.util.DepartmentUtils;
/**
 * ���Ź���
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7282789712986298140L;
	private Long parentId;//��������
	/**
	 * ��ѯ�����б�
	 */
	public String list(){
		//List<Department> list = departmentService.findAll();
		List<Department> list = null;
		if(parentId == null){
			//��ѯ���������б�
			list = departmentService.findTopList();
		}else{
			//��ѯ�Ӳ����б�
			list = departmentService.findChildren(parentId);
			
			Department dept = departmentService.getById(parentId);
			getValueStack().set("dept", dept);
		}
		
		getValueStack().set("list", list);
		return "list";
	}

	/**
	 * ����idɾ������
	 */
	public String delete(){
		departmentService.delete(model);
		return "toList";
	}
	
	/**
	 * ��ת���������ҳ��
	 */
	public String addUI(){
		//׼�������б����ݣ�����select����ʾ
		//List<Department> list = departmentService.findAll();
		List<Department> topList = departmentService.findTopList();//���ж��������б�
		List<Department> treeList = DepartmentUtils.getTreeList(topList,null);
		
		getValueStack().set("departmentList", treeList);
		
		return "addUI";
	}
	
	/**
	 * ��Ӳ���
	 */
	public String add(){
		if(parentId != null){
			Department parent = departmentService.getById(parentId);
			model.setParent(parent);//�����ϼ�����
		}else{
			model.setParent(null);
		}
		departmentService.save(model);
		
		return "toList";
	}
	
	/**
	 * ��ת���޸�ҳ��
	 */
	public String editUI(){
		//׼�����ݣ������б�
		//List<Department> list = departmentService.findAll();
		
		//׼�����ݣ�Ҫ�޸ĵĲ���
		Department dept = departmentService.getById(model.getId());
		
		List<Department> topList = departmentService.findTopList();//���ж��������б�
		List<Department> treeList = DepartmentUtils.getTreeList(topList,dept.getId());
		
		getValueStack().set("departmentList", treeList);
		getValueStack().push(dept);
		
		if(dept.getParent() != null){
			parentId = dept.getParent().getId();//����parentId��ֵ�����ڻ���
		}
		return "editUI";
	}

	/**
	 *	�޸Ĳ��� 
	 */
	public String edit(){
		//�Ȳ�ѯ���޸�
		Department dept = departmentService.getById(model.getId());
		
		dept.setName(model.getName());
		dept.setDescription(model.getDescription());
		
		if(parentId != null){
			Department parent = departmentService.getById(parentId);
			dept.setParent(parent);//�����ϼ�����
		}else{
			dept.setParent(null);
		}
		
		departmentService.update(dept);
		
		return "toList";
	}
	
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Long getParentId() {
		return parentId;
	}
}


