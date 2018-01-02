package eep.sippr.eepj.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eep.sippr.base.common.model.Page;
import eep.sippr.base.common.mybatis.model.PageBoundsRecord;
import eep.sippr.base.common.page.DbExecutor;
import eep.sippr.base.common.page.PageQueryTemplate;
import eep.sippr.eepj.dao.CourseMapper;
import eep.sippr.eepj.entity.Course;
import eep.sippr.eepj.entity.CourseExample;
import eep.sippr.eepj.service.CourseService;
import eep.sippr.eepj.service.exception.SampleDbException;
import eep.sippr.eepj.service.exception.SampleException;
import eep.sippr.eepj.service.vo.CourseCondition;

@Service
public class CourseServiceImpl implements CourseService {

	private final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
	private CourseMapper courseMapper;

	@Autowired
	public void setCourseMapper(CourseMapper courseMapper) {
		this.courseMapper = courseMapper;
	}

	@Override
	public int save(Course course) {
		if (course == null) {
			throw new SampleException("参数异常");
		}

		try {
			return this.courseMapper.insert(course);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("保存课程失败");
		}

	}

	@Override
	public int updateByPrimaryKey(Course course) {
		if (course == null || course.getId() == null) {
			throw new SampleException("参数异常");
		}

		try {
			return this.courseMapper.updateByPrimaryKey(course);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("修改课程失败");
		}
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		if (id == null) {
			throw new SampleException("参数异常");
		}

		try {
			return this.courseMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("删除课程失败");
		}
	}

	@Override
	public Page<Course> queryByPage(Page<Course> page, final CourseCondition condition) {

		if (condition == null || condition.getCategoryId() == null) {
			throw new SampleException("参数异常");
		}

		try {
			return PageQueryTemplate.selectByPage(page, new DbExecutor<Course>() {

				@Override
				public List<Course> doQuery(PageBoundsRecord<Course> pagingBounds) {

					CourseExample example = new CourseExample();
					CourseExample.Criteria criteria = example.createCriteria();
					criteria.andCategoryIdEqualTo(condition.getCategoryId());
					if (condition.getStatus() <= 3 && condition.getStatus() >= 0) {
						criteria.andStatusEqualTo(condition.getStatus());
					}

					if (StringUtils.isNotBlank(condition.getCourseNameKeys())) {
						criteria.andCourseNameLike(condition.getCourseNameKeys());
					}

					return courseMapper.selectByExample(example, pagingBounds);
				}
			});
		} catch (SampleDbException e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("查询失败");

		}
	}

}
