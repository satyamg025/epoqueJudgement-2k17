package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sooraj on 01-03-2017.
 */

public class EventDetailsPOJO {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private EventDetailsDataPOJO data;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EventDetailsDataPOJO getData() {
        return data;
    }

    public void setData(EventDetailsDataPOJO data) {
        this.data = data;
    }
}

