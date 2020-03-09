package oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import oa.dao.IFourmManageDao;
import oa.domain.Forum;
import oa.domain.PageBean;
import oa.service.IForumManageService;
import oa.util.HQLHelper;

/**
 * ������
 * @author ��Զϲ������ɯ
 *
 */
@Service
@Transactional
public class ForumManagServiceImpl  implements IForumManageService{
@Resource
private  IFourmManageDao  forumManageDao;

/**
 * ��ѯ����б�
 */
	@Override
	public List<Forum> findAll() {
		
		return forumManageDao.findAll();
	}
/**
 * ����idɾ�����
 */
	@Override
	public void delete(Forum model) {
	
		forumManageDao.delete(model.getId());
		}
  /**
   * ������
   */
	@Override
	public void save(Forum model) {
		forumManageDao.save(model);
		
	}

/**
 * 	����id��ѯ���
 */
	@Override
	public Forum getById(Long id) {
		// TODO Auto-generated method stub
		return forumManageDao.getById(id);
	}
   /**
    * ����id�޸��޸İ����Ϣ
    */
	@Override
	public void update(Forum forum) {
		
		forumManageDao.update(forum);
	}
    /**
     * ���ư��
     */
	@Override
	public void moveUp(Long id) {
		
		forumManageDao.moveUp(id);
		
	}
      /**
       * ���ư��
       */
	@Override
	public void moveDown(Long id) {
		forumManageDao.moveDown(id);
		
	}
     /**
      * ��ҳ��ѯ
      */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return forumManageDao.getPageBean(hh, currentPage);
	}

}
