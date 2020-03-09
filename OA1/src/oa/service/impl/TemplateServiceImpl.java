package oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.ITemplateDao;
import oa.domain.Template;
import oa.service.ITemplateService;

/**
 * 模块管理
 * @author 永远喜欢亚莉莎
 *
 */
@Service
@Transactional
public class TemplateServiceImpl  implements ITemplateService {
	
@Resource
private ITemplateDao templateDao;
/**
 * 查询所有模板列表
 */
	@Override
	public List<Template> findAll() {
		// TODO Auto-generated method stub
		return templateDao.findAll();
	}
	/**
	 * 保存模板对象
	 */
	@Override
	public void save(Template model) {
     templateDao.save(model);
		
	}
	/**
	 * 根据id删除模板对象
	 */
	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}
	/**
	 * 根据id查询模板对象
	 */
	@Override
	public Template getById(Long id) {
		// TODO Auto-generated method stub
		return templateDao.getById(id);
	}
	/**
	 * 修改模板实体
	 */
	@Override
	public void update(Template template) {
		
		templateDao.update(template);
		
	}
	/**
	 * 根据模板id获取此模板对应的文件输入流
	 */
	@Override
	public InputStream getInputStreamById(Long id) {
		Template template = templateDao.getById(id);
		String filePath = template.getFilePath();
		InputStream in = null;
		try {
			in = new FileInputStream(new File(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
}