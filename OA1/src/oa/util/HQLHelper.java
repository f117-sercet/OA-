package oa.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������HQL���ԵĹ�����
 * @author ��Զϲ������ɯ
 *
 */
public class HQLHelper {
	private String fromStr;//FROM �Ӿ�
	private String whereStr = "";//WHERE �Ӿ�
	private String orderByStr = "";//ORDER BY �Ӿ�
	private List<Object> args = new ArrayList<Object>();//��װHQL�ж�Ӧ�Ĳ�����Ϣ
	
	public HQLHelper() {}
	/**
	 * ͨ�����췽��ƴ��FROM �Ӿ�
	 * @param clazz
	 */
	public HQLHelper(Class clazz) {
		this.fromStr = "FROM " + clazz.getSimpleName() + " o ";
		
	}
	


	
	/**
	 * ƴ��WHERE �Ӿ�
	 * @param condition
	 * @param args
	 */
	public void addWhere(String condition,Object...args){//o.name = ?
		if(this.whereStr.length()==0){
			//��һ��ƴ��WHERE�Ӿ�
			this.whereStr = " WHERE " + condition;
		}else{
			//���ǵ�һ��ƴ��WHERE�Ӿ�
			this.whereStr += " AND " + condition;
		}
		if(args != null && args.length > 0){
			//��װ����
			for(Object o : args){
				this.args.add(o);
			}
		}
	}
	
	/**
	 * ƴ��ORDER BY �Ӿ�
	 * @param orderBy
	 * @param asc
	 */
	public void addOrderBy(String orderBy , boolean asc){
		if(this.orderByStr.length() == 0){
			//��һ��ƴ��ORDER BY �Ӿ�
			this.orderByStr = " ORDER BY " + orderBy + (asc ? " ASC " : " DESC ");
		}else{
			//���ǵ�һ��ƴ��ORDER BY �Ӿ�
			this.orderByStr += ", " + orderBy + (asc ? " ASC " : " DESC ");
		}
	}
	
	/**
	 * ��ȡ��ѯList���ϵ�HQL���
	 * @return
	 */
	public String getListHQL(){
		return this.fromStr + this.whereStr + this.orderByStr;
	}
	
	/**
	 * ��ȡ��ѯͳ�Ƽ�¼����HQL
	 * @param args
	 */
	public String getCountHQL(){
		return "SELECT COUNT(*) " + this.fromStr + this.whereStr;
	}

	public void setArgs(List<Object> args) {
		this.args = args;
	}

	public List<Object> getArgs() {
		return args;
	}
}

	

