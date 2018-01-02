package eep.sippr.eepj.controller.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CourseCategoryFormModel extends BaseFormModel {

	private Integer id;


	@Length(min = 1, max = 50, message = "课程分类名称长度应该在1-50个字符之间")
	private String name;
	@NotNull(message = "请输入排序号")
	private Integer sort;

	@NotNull(message = "选择状态")
	private Boolean status = true;
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
