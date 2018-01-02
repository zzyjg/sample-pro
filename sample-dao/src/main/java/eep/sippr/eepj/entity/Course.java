package eep.sippr.eepj.entity;

import java.io.Serializable;
import java.util.Date;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 
     */
    private Integer id;

    /**
     * VARCHAR(300) 必填<br>
     * 课程名称
     */
    private String courseName;

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 0:编辑 1上架 2:下架   3:删除
     */
    private Integer status;

    /**
     * INTEGER(10) 默认值[0]<br>
     * 课程专业ID 
     */
    private Integer categoryId;

    /**
     * VARCHAR(1000)<br>
     * 课程描述 
     */
    private String description;

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 添加时间 
     */
    private Date createTime;

    /**
     * TIMESTAMP(19) 默认值[0000-00-00 00:00:00] 必填<br>
     * 最后更新时间 
     */
    private Date updateTime;

    /**
     * INTEGER(10) 必填<br>
     * 获得 
     */
    public Integer getId() {
        return id;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * VARCHAR(300) 必填<br>
     * 获得 课程名称
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * VARCHAR(300) 必填<br>
     * 设置 课程名称
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 获得 0:编辑 1上架 2:下架   3:删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * INTEGER(10) 默认值[0] 必填<br>
     * 设置 0:编辑 1上架 2:下架   3:删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 获得 课程专业ID 
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * INTEGER(10) 默认值[0]<br>
     * 设置 课程专业ID 
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 课程描述 
     */
    public String getDescription() {
        return description;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 课程描述 
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 获得 添加时间 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(19) 默认值[CURRENT_TIMESTAMP] 必填<br>
     * 设置 添加时间 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(19) 默认值[0000-00-00 00:00:00] 必填<br>
     * 获得 最后更新时间 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(19) 默认值[0000-00-00 00:00:00] 必填<br>
     * 设置 最后更新时间 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", courseName=").append(courseName);
        sb.append(", status=").append(status);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
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
        Course other = (Course) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCourseName() == null ? other.getCourseName() == null : this.getCourseName().equals(other.getCourseName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCourseName() == null) ? 0 : getCourseName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}