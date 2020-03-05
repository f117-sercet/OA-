package oa.service;

import java.util.List;

import oa.domain.Book;


public interface IbookService {

	/**
	 * ���
	 */
	public void save(Book book);
	
	/**
	 * ����idɾ��
	 */
	public void delete(Long id);
	
	/**
	 * ����id�޸�
	 */
	public void update(Book book);
	
	/**
	 * ����id��ѯ
	 */
	public Book getById(Long id);
	
	/**
	 * һ�β�ѯ�������
	 */
	public List<Book> getByIds(Long[] ids);
	
	/**
	 * ��ѯ����
	 */
	public List<Book> findAll();

}

