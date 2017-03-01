package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 3/1/17.
 */
public class GetSoloTeamsPOJO {
    @SerializedName("name")
    @Expose
    private List<String> name = null;
    @SerializedName("year")
    @Expose
    private List<String> year = null;
    @SerializedName("event_name")
    @Expose
    private List<String> eventName = null;
    @SerializedName("mob")
    @Expose
    private List<String> mob = null;
    @SerializedName("uni_roll_no")
    @Expose
    private List<String> uniRollNo = null;
    @SerializedName("lib_card_no")
    @Expose
    private List<String> libCardNo = null;
    @SerializedName("uniq_id")
    @Expose
    private List<String> uniqId = null;
    @SerializedName("event_id")
    @Expose
    private List<String> eventId = null;
    @SerializedName("attr_id")
    @Expose
    private List<String> attrId = null;
    @SerializedName("attributes")
    @Expose
    private List<String> attributes = null;
    @SerializedName("max")
    @Expose
    private List<String> max = null;
    @SerializedName("min")
    @Expose
    private List<String> min = null;
    @SerializedName("count")
    @Expose
    private Integer count;

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }

    public List<String> getEventName() {
        return eventName;
    }

    public void setEventName(List<String> eventName) {
        this.eventName = eventName;
    }

    public List<String> getMob() {
        return mob;
    }

    public void setMob(List<String> mob) {
        this.mob = mob;
    }

    public List<String> getUniRollNo() {
        return uniRollNo;
    }

    public void setUniRollNo(List<String> uniRollNo) {
        this.uniRollNo = uniRollNo;
    }

    public List<String> getLibCardNo() {
        return libCardNo;
    }

    public void setLibCardNo(List<String> libCardNo) {
        this.libCardNo = libCardNo;
    }

    public List<String> getUniqId() {
        return uniqId;
    }

    public void setUniqId(List<String> uniqId) {
        this.uniqId = uniqId;
    }

    public List<String> getEventId() {
        return eventId;
    }

    public void setEventId(List<String> eventId) {
        this.eventId = eventId;
    }

    public List<String> getAttrId() {
        return attrId;
    }

    public void setAttrId(List<String> attrId) {
        this.attrId = attrId;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<String> getMax() {
        return max;
    }

    public void setMax(List<String> max) {
        this.max = max;
    }

    public List<String> getMin() {
        return min;
    }

    public void setMin(List<String> min) {
        this.min = min;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
