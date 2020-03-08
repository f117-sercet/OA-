package oa.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import oa.base.BaseDaoImpl;
import oa.dao.IBookDao;
import oa.domain.Book;
/**
 * BookDao, �̳�BaseDaoImpl
 * @author ��Զϲ������ɯ
 *
 */
@Repository
public class BookDaoImpl extends BaseDaoImpl<Book> implements IBookDao{

}
