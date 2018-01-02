package eep.sippr.eepj.service.impl;

import java.util.Date;
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
import eep.sippr.eepj.dao.CourseCategoryMapper;
import eep.sippr.eepj.entity.CourseCategory;
import eep.sippr.eepj.entity.CourseCategoryExample;
import eep.sippr.eepj.service.CourseCategoryService;
import eep.sippr.eepj.service.exception.SampleDbException;
import eep.sippr.eepj.service.exception.SampleException;
import eep.sippr.eepj.service.vo.CourseCategoryCondition;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {

	private final static Logger logger = LoggerFactory.getLogger(CourseCategoryServiceImpl.class);
	private CourseCategoryMapper courseCategoryMapper;

	@Autowired
	public void setCourseCategoryMapper(CourseCategoryMapper courseCategoryMapper) {
		this.courseCategoryMapper = courseCategoryMapper;
	}

	@Override
	public CourseCategory queryByPrimaryKey(Integer id) {

		if (id == null) {
			throw new SampleException("参数无效！");
		}
		try {
			return courseCategoryMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("主键查询失败！");
		}

	}

	@Override
	public int insert(CourseCategory category) {
		try {
			category.setCreateTime(new Date());
			return this.courseCategoryMapper.insert(category);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("保存课程分类失败！");
		}

	}

	@Override
	public int updateByPrimaryKey(CourseCategory category) {
		try {
			return this.courseCategoryMapper.updateByPrimaryKeySelective(category);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("更新课程分类失败！");
		}

	}

	@Override
	public Page<CourseCategory> queryByPage(Page<CourseCategory> page, final CourseCategoryCondition condition) {

		try {
			return PageQueryTemplate.selectByPage(page, new DbExecutor<CourseCategory>() {

				@Override
				public List<CourseCategory> doQuery(PageBoundsRecord<CourseCategory> pagingBounds) {
					CourseCategoryExample example = new CourseCategoryExample();
					if (condition != null) {
						CourseCategoryExample.Criteria criteria = example.createCriteria();
						criteria.andStatusEqualTo(condition.getStatus() != null && condition.getStatus() == 1);
						if (StringUtils.isNotBlank(condition.getCategoryNameKeys())) {
							criteria.andCategoryNameLike(condition.getCategoryNameKeys());
						}
						if (condition.getParentId() != null) {
							criteria.andParentIdEqualTo(condition.getParentId());
						}
					}

					return courseCategoryMapper.selectByExample(example, pagingBounds);
				}
			});
		} catch (Exception e) {
			throw new SampleDbException("分页查询失败！");
		}

	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		try {
			return this.courseCategoryMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new SampleDbException("删除课程分类失败！");
		}
	}

}
