package com.dky.modules.sys.model;


import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author bowen
 * @since 2019-04-07
 */
@TableName("a_base_recommend")
public class Recommend implements Serializable {

    private static final long serialVersionUID = 1L;

    //@TableId(value = "id", type = IdType.AUTO)
    @TableId
    private Integer id;
    private Integer studentId;
    private Integer projectId;
    private Integer teacherId;
    private String teacherName;
    /**
     * 教师所打分数
     */
    private Double point;
    /**
     * 评语内容录入
     */
    private String recommendText;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 教务处表示是否通过
     */
    private Integer isOk;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public String getRecommendText() {
        return recommendText;
    }

    public void setRecommendText(String recommendText) {
        this.recommendText = recommendText;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsOk() {
        return isOk;
    }

    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
    }

    @Override
    public String toString() {
        return "ABaseRecommend{" +
                ", id=" + id +
                ", studentId=" + studentId +
                ", projectId=" + projectId +
                ", teacherId=" + teacherId +
                ", teacherName=" + teacherName +
                ", point=" + point +
                ", recommendText=" + recommendText +
                ", updateTime=" + updateTime +
                ", isOk=" + isOk +
                "}";
    }
}

