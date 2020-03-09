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
 * ģ�����
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class TemplateServiceImpl  implements ITemplateService {
	
@Resource
private ITemplateDao templateDao;
/**
 * ��ѯ����ģ���б�
 */
	@Override
	public List<Template> findAll() {
		// TODO Auto-generated method stub
		return templateDao.findAll();
	}
	/**
	 * ����ģ�����
	 */
	@Override
	public void save(Template model) {
     templateDao.save(model);
		
	}
	/**
	 * ����idɾ��ģ�����
	 */
	@Override
	public void delete(Long id) {
		templateDao.delete(id);
	}
	/**
	 * ����id��ѯģ�����
	 */
	@Override
	public Template getById(Long id) {
		// TODO Auto-generated method stub
		return templateDao.getById(id);
	}
	/**
	 * �޸�ģ��ʵ��
	 */
	@Override
	public void update(Template template) {
		
		templateDao.update(template);
		
	}
	/**
	 * ����ģ��id��ȡ��ģ���Ӧ���ļ�������
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