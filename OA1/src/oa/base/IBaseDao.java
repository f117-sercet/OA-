package oa.base;

import java.util.List;

import oa.domain.PageBean;
import oa.util.HQLHelper;



/**
 * ͨ��Dao�ӿ�
 * @author ��Զϲ������ɯ
 * 
 */
public interface IBaseDao<T> {
	/**
	 * ���
	 */
	public void save(T entity);
	
	/**
	 * ����idɾ��
	 */
	public void delete(Long id);
	
	/**
	 * ����id�޸�
	 */
	public void update(T entity);
	
	/**
	 * ����id��ѯ
	 */
	public T getById(Long id);
	
	/**
	 * һ�β�ѯ�������
	 */
	public List<T> getByIds(Long[] ids);
	
	/**
	 * ��ѯ����
	 */
	public List<T> findAll();
	
	/**
	 * ������ҳ����
	 */
	public PageBean getPageBean(HQLHelper hh,int currentPage);	

}
