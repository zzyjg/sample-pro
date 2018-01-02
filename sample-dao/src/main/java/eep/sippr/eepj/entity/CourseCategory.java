package eep.sippr.eepj.entity;

import java.io.Serializable;
import java.util.Date;

public class CourseCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 主键
     */
    private Integer id;

    /**
     * VARCHAR(50) 必填<br>
     * 课程分类名称
     */
    private String categoryName;

    /**
     * BIT 默认值[0] 必填<br>
     * 状态 1:有效0无效-1删除
     */
    private Boolean status;

    /**
     * TIMESTAMP(19)<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * INTEGER(10) 默认值[0]<br>
     * 父ID 
     */
    private Integer parentId;

    /**
     * INTEGER(10) 默认值[0]<br>
     * 排序字段
     */
    private Integer sort;

    /**
     * INTEGER(10) 必填<br>
     * 获得 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 获得 课程分类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * VARCHAR(50) 必填<br>
     * 设置 课程分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * BIT 默认值[0] 必填<br>
     * 获得 状态 1:有效0无效-1删除
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * BIT 默认值[0] 必填<br>
     * 设置 状态 1:有效0无效-1删除
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * TIMESTAMP(19)<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(19)<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 获得 父ID 
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 设置 父ID 
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 获得 排序字段
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 设置 排序字段
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", parentId=").append(parentId);
        sb.append(", sort=").append(sort);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CourseCategory other = (CourseCategory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}