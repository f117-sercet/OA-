package oa.service;

import org.springframework.stereotype.Controller;

/**
 * ��ҳAction
 * @author ��Զϲ������ɯ
 *
 */
@Controller
public class HomeAction {
	/**
	 * ��ת����ҳ��
	 */
	public String index(){
		return "index";
	}
	/**
	 * ��ת��top.jspҳ��
	 */
	public String top(){
		return "top";
	}
	/**
	 * ��ת��left.jspҳ��
	 */
	public String left(){
		return "left";
	}
	/**
	 * ��ת��right.jspҳ��
	 */
	public String right(){
		return "right";
	}
	/**
	 * ��ת��bottom.jspҳ��
	 */
	public String bottom(){
		return "bottom";
	}
}

}
