package eep.sippr.eepj.service.vo;

public class CourseCondition {

	private Integer categoryId;
	private Integer status;
	private String courseNameKeys;

	public void setCourseNameKeys(String courseNameKeys) {
		this.courseNameKeys = courseNameKeys;
	}

	public String getCourseNameKeys() {
		return courseNameKeys;
	}

	/**
	 * INTEGER(10) 默认值[0] 必填<br>
	 * 0:编辑 1上架 2:下架 3:删除,其他值表示查询全部
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * INTEGER(10) 默认值[0] 必填<br>
	 * 0:编辑 1上架 2:下架 3:删除,其他值表示查询全部
	 */
	public Integer getStatus() {
		return status;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
