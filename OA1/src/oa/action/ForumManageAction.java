package oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import oa.base.BaseAction;
import oa.domain.Forum;
import oa.domain.PageBean;
import oa.util.HQLHelper;

/**
 * ������
 * @author ��Զϲ������ɯ
 *
 */
@Controller
@Scope("prototype")
public class ForumManageAction extends  BaseAction<Forum> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -573662044169061228L;
	/**
	 * ��ѯ����б�
	 */
	public String list(){
		//List<Forum> list = forumManageService.findAll();
		//getValueStack().set("list", list);
		
		HQLHelper hh = new HQLHelper(Forum.class);
		hh.addOrderBy("o.position", true);
		
		PageBean pb = forumManageService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		return "list";
	}
	
	/**
	 * ����idɾ�����
	 */
	public String delete(){
		forumManageService.delete(model);
		return "toList";
	}
	
	/**
	 * ��ת����Ӱ��ҳ��
	 */
	public String addUI(){
		return "addUI";
	}
	
	/**
	 * ��Ӱ��
	 */
	public String add(){
		forumManageService.save(model);
		return "toList";
	}
	
	/**
	 * ��ת������޸�ҳ��
	 */
	public String editUI(){
		Forum forum = forumManageService.getById(model.getId());
		
		getValueStack().push(forum);
		return "editUI";
	}
	
	/**
	 * �޸İ��
	 */
	public String edit(){
		//�Ȳ�ѯ�����޸�
		Forum forum = forumManageService.getById(model.getId());
		
		forum.setName(model.getName());
		forum.setDescription(model.getDescription());
		
		forumManageService.update(forum);
		return "toList";
	}
	
	/**
	 * ����
	 */
	public String moveUp(){
		forumManageService.moveUp(model.getId());
		
		return "toList";
	}

	/**
	 * ����
	 */
	public String moveDown(){
		forumManageService.moveDown(model.getId());
		return "toList";
	}
}

