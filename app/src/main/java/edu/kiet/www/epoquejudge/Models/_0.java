package edu.kiet.www.epoquejudge.Models;

/**
 * Created by satyam on 2/28/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _0 {

    @SerializedName("Team_name")
    @Expose
    private String teamName;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Team_member")
    @Expose
    private String teamMember;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("Branch_id")
    @Expose
    private String branchId;
    @SerializedName("event_name")
    @Expose
    private String eventName;
    @SerializedName("MOB")
    @Expose
    private String mOB;
    @SerializedName("Uni_Roll_No")
    @Expose
    private String uniRollNo;
    @SerializedName("Lib_Card_No")
    @Expose
    private String libCardNo;
    @SerializedName("G_id")
    @Expose
    private String gId;
    @SerializedName("Event_id")
    @Expose
    private String eventId;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getMOB() {
        return mOB;
    }

    public void setMOB(String mOB) {
        this.mOB = mOB;
    }

    public String getUniRollNo() {
        return uniRollNo;
    }

    public void setUniRollNo(String uniRollNo) {
        this.uniRollNo = uniRollNo;
    }

    public String getLibCardNo() {
        return libCardNo;
    }

    public void setLibCardNo(String libCardNo) {
        this.libCardNo = libCardNo;
    }

    public String getGId() {
        return gId;
    }

    public void setGId(String gId) {
        this.gId = gId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

}