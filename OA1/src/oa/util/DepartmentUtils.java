package oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import oa.domain.Department;


/**
 * 
 * @author ��Զϲ������ɯ
 *
 */
public class DepartmentUtils {

	/**
	 * @param topList  ���������б�
	 * @param removeId ɾ�����ŵ�id
	 * @return
	 */
	public static List<Department> getTreeList(List<Department> topList,Long removeId) {
		List<Department> treeList = new ArrayList<Department>();
		
		walkTree(topList,treeList,"��",removeId);
		
		return treeList;
	}
	
	/**
	 * ��֯���β�������
	 */
	public static void walkTree(Collection<Department> topList,List<Department> treeList ,String prefix,Long removeId){
		for(Department d : topList){
			if(removeId != null && d.getId().equals(removeId)){
				continue;
			}
			
			Department copy = new Department();
			copy.setId(d.getId());
			copy.setName(prefix + d.getName());
			
			//����
			treeList.add(copy);
			//����
			Set<Department> children = d.getChildren();
			walkTree(children,treeList,"��" + prefix,removeId);
		}
	}
}

