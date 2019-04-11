package com.dky.modules.sys.model;

import java.io.Serializable;

/**
 * describe:
 *
 * @author bowen
 * @date 2019/04/11
 */
public class Defense implements Serializable {
    private Integer id;
    private Integer groupId;
    private String time;
    private String place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Defense{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
