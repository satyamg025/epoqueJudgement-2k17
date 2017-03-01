package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by satyam on 2/28/17.
 */
public class A {

    @SerializedName("0")
    @Expose
    private List<List<edu.kiet.www.epoquejudge.Models._0>> _0 = null;
    @SerializedName("Category")
    @Expose
    private String category;

    public List<List<edu.kiet.www.epoquejudge.Models._0>> get0() {
        return _0;
    }

    public void set0(List<List<edu.kiet.www.epoquejudge.Models._0>> _0) {
        this._0 = _0;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}