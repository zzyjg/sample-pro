package eep.sippr.eepj.dao;

import eep.sippr.eepj.entity.Course;
import eep.sippr.eepj.entity.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper extends eep.sippr.base.common.mybatis.BaseMapper<Course, Integer, CourseExample> {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}