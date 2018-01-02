package eep.sippr.eepj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;

import eep.sippr.base.common.model.Page;
import eep.sippr.eepj.controller.model.CourseCategoryFormModel;
import eep.sippr.eepj.entity.CourseCategory;
import eep.sippr.eepj.service.CourseCategoryService;
import eep.sippr.eepj.service.exception.SampleException;

@Controller
public class CourseCategoryController {

	private CourseCategoryService courseCategoryService;

	@Autowired
	public void setCourseCategoryService(CourseCategoryService courseCategoryService) {
		this.courseCategoryService = courseCategoryService;
	}

	@RequestMapping("course-category")
	public String index() {
		return "course-category";
	}

	@RequestMapping(value = "queery-by-page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Page<CourseCategory> queryByPage(
			@RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset) {

		Page<CourseCategory> page = Page.makePageByOffsetRecord(offset, limit);
		return this.courseCategoryService.queryByPage(page, null);

	}

	@RequestMapping(value = "course-category/add", method = RequestMethod.GET)
	public String add(Model model) {
		if (!model.containsAttribute("model")) {
			model.addAttribute("model", new CourseCategoryFormModel());
		}

		return "course-category-add";
	}

	@RequestMapping(value = "course-category/add", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("model") CourseCategoryFormModel formModel, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return add(model);
		}

		CourseCategory category = new CourseCategory();
		category.setCategoryName(formModel.getName());
		category.setSort(formModel.getSort());
		category.setStatus(formModel.isStatus());
		try {
			this.courseCategoryService.insert(category);

			return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/course-category";
		} catch (Exception e) {
			result.rejectValue("error", null, e.getMessage());
			return add(model);
		}

	}

	@RequestMapping(value = "course-category/update", method = RequestMethod.GET)
	public String edit(@RequestParam(value = "id") Integer id, Model model) {
		if (!model.containsAttribute("model")) {

			CourseCategory category = this.courseCategoryService.queryByPrimaryKey(id);

			if (category == null) {
				throw new SampleException("修改的记录不存在！");
			}

			CourseCategoryFormModel formModel = new CourseCategoryFormModel();
			formModel.setId(category.getId());
			formModel.setName(category.getCategoryName());
			formModel.setSort(category.getSort());
			formModel.setStatus(category.getStatus());
			model.addAttribute("model", formModel);
		}

		return "course-category-edit";
	}

	@RequestMapping(value = "course-category/update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("model") CourseCategoryFormModel formModel, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return edit(formModel.getId(), model);
		}

		CourseCategory category = this.courseCategoryService.queryByPrimaryKey(formModel.getId());

		if (category == null) {
			throw new SampleException("修改的记录不存在！");
		}

		category.setId(formModel.getId());
		category.setCategoryName(formModel.getName());
		category.setSort(formModel.getSort());
		category.setStatus(formModel.isStatus());
		try {
			int count = this.courseCategoryService.updateByPrimaryKey(category);
			if (count == 1) {
				return UrlBasedViewResolver.REDIRECT_URL_PREFIX + "/course-category";
			}

			throw new SampleException("修改的记录不存在！");
		} catch (Exception e) {
			result.rejectValue("error", null, e.getMessage());
			return edit(formModel.getId(), model);
		}

	}

	@RequestMapping(value = "course-category/delete/{id}", method = RequestMethod.POST)
	public @ResponseBody JSONObject delete(@PathVariable("id") Integer id) {
		JSONObject result = new JSONObject();
		try {
			int count = this.courseCategoryService.deleteByPrimaryKey(id);
			if (count == 1) {
				result.put("code", 0);
				result.put("message", "操作成功");
			} else {
				result.put("code", 1);
				result.put("message", "删除的记录不存在！");
			}
		} catch (Exception e) {
			result.put("code", 1);
			result.put("message", e.getMessage());
		}
		return result;
	}
}
