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
 * 板块管理
 * @author 永远喜欢亚莉莎
 *
 */
@Service
@Transactional
public class ForumManagServiceImpl  implements IForumManageService{
@Resource
private  IFourmManageDao  forumManageDao;

/**
 * 查询板块列表
 */
	@Override
	public List<Forum> findAll() {
		
		return forumManageDao.findAll();
	}
/**
 * 根据id删除板块
 */
	@Override
	public void delete(Forum model) {
	
		forumManageDao.delete(model.getId());
		}
  /**
   * 保存板块
   */
	@Override
	public void save(Forum model) {
		forumManageDao.save(model);
		
	}

/**
 * 	根据id查询板块
 */
	@Override
	public Forum getById(Long id) {
		// TODO Auto-generated method stub
		return forumManageDao.getById(id);
	}
   /**
    * 根据id修改修改板块信息
    */
	@Override
	public void update(Forum forum) {
		
		forumManageDao.update(forum);
	}
    /**
     * 上移板块
     */
	@Override
	public void moveUp(Long id) {
		
		forumManageDao.moveUp(id);
		
	}
      /**
       * 下移板块
       */
	@Override
	public void moveDown(Long id) {
		forumManageDao.moveDown(id);
		
	}
     /**
      * 分页查询
      */
	@Override
	public PageBean getPageBean(HQLHelper hh, int currentPage) {
		return forumManageDao.getPageBean(hh, currentPage);
	}

}
