package oa.interceptor;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;

import oa.domain.User;

/**
 * ����Ȩ�޼���������
 * @author ��Զϲ������ɯ
 *
 */
public class CheckPrivilegeInceptor {
	
	/**
	 * ���ط���
	 */
	public String intercept(ActionInvocation ai) throws Exception {
	
	//��Session�л�ȡ��¼�û�
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
			
			String actionName = ai.getProxy().getActionName();
			String namespace = ai.getProxy().getNamespace();
			String url = namespace + actionName;//  /user_addUI
			
			if(url.endsWith("UI")){
				//�������URL��UI��β����ȥ��
				url = url.substring(0, url.length() - 2);
			}
			
			//System.out.println("����URL=" + url);
			
			// һ ���û�û�е�¼
			if(user == null){
				// a ����û����ʵ��ǵ�¼����,�����
				if("/user_login".equals(url)){
					return ai.invoke();
				}else{
					// b ����û����ʵĲ��ǵ�¼���ܣ�����ת����¼ҳ��
					return "loginUI";
				}
			}else{
				// ���� �û��Ѿ���¼
				@SuppressWarnings("unchecked")
				List<String> allUrl = (List<String>) ServletActionContext.getServletContext().getAttribute("allUrl");
				//����û����ʵ���Ҫ��֤��Ȩ��
				if(allUrl.contains(url)){
					boolean b = user.hasPrivilegeByUrl(url);
					if(b){
						// a ����û���Ȩ�ޣ������
						return ai.invoke();
					}else{
						// b ����û�û��Ȩ�ޣ�����ת��û��Ȩ�޵���ʾҳ��
						return "noPrivilegeUI";
					}
				}else{
					//����û����ʵĲ���Ҫ��֤��Ȩ��
					return ai.invoke();
				}
			}
		}
	}



