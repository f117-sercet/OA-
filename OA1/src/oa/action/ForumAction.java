package oa.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import oa.base.BaseAction;
import oa.domain.Forum;
import oa.domain.PageBean;
import oa.domain.Topic;
import oa.util.HQLHelper;

/**
 * ���������
 * @author ��Զϲ������ɯ
 * 
 */
@Controller
@Scope("prototype")
public class ForumAction  extends BaseAction<Forum>{
	/**
	 * <option value="0">ȫ������</option>
	 * <option value="1">ȫ��������</option>
	 */
	private int viewType;//������������ʾ��Щ����
	
	/**
	 *  <option value="0">Ĭ�����򣨰�������ʱ�����򣬵������ö�������ǰ�棩</option>
		<option value="1">��������ʱ������</option>
		<option value="2">�����ⷢ��ʱ������</option>
		<option value="3">���ظ���������</option>
	 */
	private int orderBy;//���������������ֶ�
	
	/**
	 * <option value="false">����</option>
	   <option value="true">����</option>
	 */
	private boolean asc;//����������������߽���
	
	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	/**
	 * ��ѯ����б�
	 */
	public String list(){
		/*List<Forum> list =forumService.findAll();
		getValueStack().set("list", list);*/
		
		HQLHelper hh = new HQLHelper(Forum.class);
		hh.addOrderBy("o.position", true);
		
		PageBean pb = forumService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		return "list";
	}
	
	/**
	 * ��ѯ�����б����� ��飩
	 */
	public String show(){
		//���ݰ��id��ѯ��飬������ҳ����ʾ
		Forum forum = forumService.getById(model.getId());
		getValueStack().push(forum);
		
		//���ݰ��id��ѯ�����б�
		/*List<Topic> topicList = topicService.findTopicByForum(model);
		getValueStack().set("topicList", topicList);*/
		
		HQLHelper hh = new HQLHelper(Topic.class);
		hh.addWhere("o.forum = ?", model);
		if(viewType == 1){
			//��ѯ������
			hh.addWhere("o.type = ?", 1);
		}
		if(orderBy == 0){
			//<option value="0">Ĭ�����򣨰�������ʱ�����򣬵������ö�������ǰ�棩</option>
			hh.addOrderBy("CASE o.type WHEN 2 THEN 2 ELSE 1 END", false);
			hh.addOrderBy("o.postTime", false);
		}else if(orderBy == 1){
			//<option value="1">��������ʱ������</option>
			hh.addOrderBy("o.lastUpdateTime", asc);
		}else if(orderBy == 2){
			//<option value="2">�����ⷢ��ʱ������</option>
			hh.addOrderBy("o.postTime", asc);
		}else{
			//<option value="3">���ظ���������</option>
			hh.addOrderBy("o.replyCount", asc);
		}
		
		PageBean pb = topicService.getPageBean(hh,currentPage);
		getValueStack().push(pb);
		return "forumShow";
	}
}


