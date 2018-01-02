package eep.sippr.eepj.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
import eep.sippr.eepj.entity.CourseCategory;
import eep.sippr.eepj.service.CourseCategoryService;

@Controller
public class TestController {
	
	@Autowired	
	private CourseCategoryService courseCategoryService;

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("insert")
	public String insert(Model model) {		
		CourseCategory category=new CourseCategory();
		category.setCategoryName("YJGName-"+new Date());
		category.setCreateTime(new Date());
		category.setSort(1);
		category.setStatus(true);
		courseCategoryService.insert(category);
		model.addAttribute("msg","增加成功");
		return "index";
	}
}
