package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 2/28/17.
 */
public class Example {

    @SerializedName("a")
    @Expose
    private A a;
    @SerializedName("attr")
    @Expose
    private Attr attr;
    @SerializedName("already_judge")
    @Expose
    private List<Object> alreadyJudge = null;
    @SerializedName("already_judge_group")
    @Expose
    private List<AlreadyJudgeGroup> alreadyJudgeGroup = null;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public List<Object> getAlreadyJudge() {
        return alreadyJudge;
    }

    public void setAlreadyJudge(List<Object> alreadyJudge) {
        this.alreadyJudge = alreadyJudge;
    }

    public List<AlreadyJudgeGroup> getAlreadyJudgeGroup() {
        return alreadyJudgeGroup;
    }

    public void setAlreadyJudgeGroup(List<AlreadyJudgeGroup> alreadyJudgeGroup) {
        this.alreadyJudgeGroup = alreadyJudgeGroup;
    }
}