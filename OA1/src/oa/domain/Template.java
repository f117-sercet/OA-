package oa.domain;
/**
 * ���ʵ��
 * @author ��Զϲ������ɯ
 *
 */
public class Template {
	private Long id;
	private String name;//ģ������
	private String processDefinitionKey;//��ģ����������̶����key
	private String filePath;//��ģ���Ӧ���ļ��Ĵ洢·��
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}
	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

}
