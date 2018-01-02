package eep.sippr.eepj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eep.sippr.base.common.model.Page;
import eep.sippr.eepj.entity.Course;

@Controller
public class CourseController {

	@RequestMapping("course")
	public String index() {
		return "course";
	}

	public Page<Course> queryByPage(@RequestParam("limit") Integer limit, @RequestParam("offset") Integer offset) {
		return null;
	}

}
