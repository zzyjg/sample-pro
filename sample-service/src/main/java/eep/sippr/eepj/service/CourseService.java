package eep.sippr.eepj.service;

import eep.sippr.base.common.model.Page;
import eep.sippr.eepj.entity.Course;
import eep.sippr.eepj.service.vo.CourseCondition;

public interface CourseService {

	int save(Course course);
	int updateByPrimaryKey(Course course);
	int deleteByPrimaryKey(Integer id);
	public Page<Course> queryByPage(Page<Course> page,CourseCondition condition);
}
