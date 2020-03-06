package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IBookDao;
import oa.domain.Book;
import oa.service.IbookService;
@Service
@Transactional
public class BookServiceImpl implements IbookService {
	
@Resource
private IBookDao bookDao;

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
          bookDao.delete(id);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub

               bookDao.update(book);        	
	}

	@Override
	public Book getById(Long id) {
		return bookDao.getById(id);
	}

	@Override
	public List<Book> getByIds(Long[] ids) {
		return bookDao.getByIds(ids);
	}

	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

}
