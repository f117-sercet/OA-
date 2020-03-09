package oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Book;

/**
 * ���Ź���
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class BookAction extends  BaseAction<Book>{
	public String execute() throws Exception {
		System.out.println(model);
		
		//bookService.save(model);
		bookService.delete(model.getId());
		return NONE;
	}
}


