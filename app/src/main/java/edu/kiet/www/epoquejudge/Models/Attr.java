package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 2/28/17.
 */
public class Attr {

    @SerializedName("attr")
    @Expose
    private List<Attr_> attr = null;
    @SerializedName("count")
    @Expose
    private Integer count;

    public List<Attr_> getAttr() {
        return attr;
    }

    public void setAttr(List<Attr_> attr) {
        this.attr = attr;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}