package oa.dao.impl;

import java.io.File;

import org.springframework.stereotype.Repository;

import oa.base.BaseDaoImpl;
import oa.dao.ITemplateDao;
import oa.domain.Template;
/**
 * 模板管理
 * @author 永远喜欢亚莉莎
 *
 */
@Repository
public class TemplateDaoImpl extends BaseDaoImpl<Template> implements ITemplateDao {
	/*
	 * 重写删除方法
	 */
	public void delete(Long id) {
		Template template = super.getById(id);
		String filePath = template.getFilePath();//获得文件的存储路径
		
		//删除文件
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		super.delete(id);//删除数据
	}
}
