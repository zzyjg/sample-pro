package eep.sippr.eepj.service;

import eep.sippr.base.common.model.Page;
import eep.sippr.eepj.entity.CourseCategory;
import eep.sippr.eepj.service.vo.CourseCategoryCondition;

public interface CourseCategoryService {

	int insert(CourseCategory category);
	
	int updateByPrimaryKey(CourseCategory category); 
	
	Page<CourseCategory> queryByPage(Page<CourseCategory> page,CourseCategoryCondition condition);
	
	int deleteByPrimaryKey(Integer id);

	CourseCategory queryByPrimaryKey(Integer id);
}
