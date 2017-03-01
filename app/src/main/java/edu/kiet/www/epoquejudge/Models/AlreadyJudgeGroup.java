package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by satyam on 2/28/17.
 */
public class AlreadyJudgeGroup {

    @SerializedName("G_id")
    @Expose
    private String gId;

    public String getGId() {
        return gId;
    }

    public void setGId(String gId) {
        this.gId = gId;
    }

}