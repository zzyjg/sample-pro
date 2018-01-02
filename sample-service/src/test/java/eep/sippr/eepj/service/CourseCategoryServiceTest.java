package eep.sippr.eepj.service;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eep.sippr.base.common.model.Page;
import eep.sippr.eepj.entity.CourseCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class CourseCategoryServiceTest {

	@Autowired
	private CourseCategoryService courseCategoryService;
	
	@Test
	public void testInsert() {
		CourseCategory category=new CourseCategory();
		category.setCategoryName("testName");
		category.setCreateTime(new Date());
		category.setSort(1);
		category.setStatus(true);
		int count=courseCategoryService.insert(category);
		assertTrue(count==1);
	}

	@Test
	public void testUpdateByPrimaryKey() {
		
	}

	@Test
	public void testQueryByPage() { 
		 Page<CourseCategory> page=Page.makePageByOffsetRecord(0, 10);
		 courseCategoryService.queryByPage(page,null);
		 System.out.println(page);
	}

	@Test
	public void testDeleteByPrimaryKey() {

	}
}
