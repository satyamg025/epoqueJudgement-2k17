package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 3/1/17.
 */
public class GetGroupTeamsPOJO {@SerializedName("team_name")
@Expose
private List<String> teamName = null;
    @SerializedName("name")
    @Expose
    private List<String> name = null;
    @SerializedName("team_leader")
    @Expose
    private List<String> teamLeader = null;
    @SerializedName("team_member")
    @Expose
    private List<String> teamMember = null;
    @SerializedName("year")
    @Expose
    private List<String> year = null;
    @SerializedName("branch_id")
    @Expose
    private List<List<String>> branchId = null;
    @SerializedName("event_name")
    @Expose
    private List<String> eventName = null;
    @SerializedName("mob")
    @Expose
    private List<String> mob = null;
    @SerializedName("uni_roll_no")
    @Expose
    private List<List<String>> uniRollNo = null;
    @SerializedName("lib_card_no")
    @Expose
    private List<List<String>> libCardNo = null;
    @SerializedName("gid")
    @Expose
    private List<String> gid = null;
    @SerializedName("event_id")
    @Expose
    private List<String> eventId = null;
    @SerializedName("member_name")
    @Expose
    private List<List<String>> memberName = null;
    @SerializedName("member_branch_id")
    @Expose
    private List<List<String>> memberBranchId = null;
    @SerializedName("member_uni_roll_no")
    @Expose
    private List<List<String>> memberUniRollNo = null;
    @SerializedName("member_lib_card_no")
    @Expose
    private List<List<String>> memberLibCardNo = null;
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

    public List<String> getTeamName() {
        return teamName;
    }

    public void setTeamName(List<String> teamName) {
        this.teamName = teamName;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(List<String> teamLeader) {
        this.teamLeader = teamLeader;
    }

    public List<String> getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(List<String> teamMember) {
        this.teamMember = teamMember;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }

    public List<List<String>> getBranchId() {
        return branchId;
    }

    public void setBranchId(List<List<String>> branchId) {
        this.branchId = branchId;
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

    public List<List<String>> getUniRollNo() {
        return uniRollNo;
    }

    public void setUniRollNo(List<List<String>> uniRollNo) {
        this.uniRollNo = uniRollNo;
    }

    public List<List<String>> getLibCardNo() {
        return libCardNo;
    }

    public void setLibCardNo(List<List<String>> libCardNo) {
        this.libCardNo = libCardNo;
    }

    public List<String> getGid() {
        return gid;
    }

    public void setGid(List<String> gid) {
        this.gid = gid;
    }

    public List<String> getEventId() {
        return eventId;
    }

    public void setEventId(List<String> eventId) {
        this.eventId = eventId;
    }

    public List<List<String>> getMemberName() {
        return memberName;
    }

    public void setMemberName(List<List<String>> memberName) {
        this.memberName = memberName;
    }

    public List<List<String>> getMemberBranchId() {
        return memberBranchId;
    }

    public void setMemberBranchId(List<List<String>> memberBranchId) {
        this.memberBranchId = memberBranchId;
    }

    public List<List<String>> getMemberUniRollNo() {
        return memberUniRollNo;
    }

    public void setMemberUniRollNo(List<List<String>> memberUniRollNo) {
        this.memberUniRollNo = memberUniRollNo;
    }

    public List<List<String>> getMemberLibCardNo() {
        return memberLibCardNo;
    }

    public void setMemberLibCardNo(List<List<String>> memberLibCardNo) {
        this.memberLibCardNo = memberLibCardNo;
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
