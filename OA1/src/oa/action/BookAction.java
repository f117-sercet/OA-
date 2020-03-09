package oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Book;

/**
 * 部门管理
 * @author 永远喜欢亚莉莎
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


