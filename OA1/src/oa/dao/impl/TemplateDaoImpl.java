package oa.dao.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.ITemplateDao;
import oa.domain.Template;
/**
 * ģ�����
 * @author ��Զϲ������ɯ
 *
 */
@Repository
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements ITemplateDao {
	/*
	 * ��дɾ������
	 */
	public void delete(Long id) {
		Template template = super.getById(id);
		String filePath = template.getFilePath();//����ļ��Ĵ洢·��
		
		//ɾ���ļ�
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		super.delete(id);//ɾ������
	}
}
