package eep.sippr.eepj.service.vo;

public class CourseCategoryCondition {

	private Integer parentId;

	private String categoryNameKeys;

	private Integer status;

	/**
	 * 1表示有效，否则表示无效
	 * @return
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 1表示有效，否则表示无效
	 * @return
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setCategoryNameKeys(String categoryNameKeys) {
		this.categoryNameKeys = categoryNameKeys;
	}

	public String getCategoryNameKeys() {
		return categoryNameKeys;
	}
 
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
