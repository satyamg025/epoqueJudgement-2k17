package edu.kiet.www.epoquejudge.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sooraj on 01-03-2017.
 */

public class EventDetailsDataPOJO {

        @SerializedName("type")
        @Expose
        private List<String> type = null;
        @SerializedName("category")
        @Expose
        private List<String> category = null;
        @SerializedName("name")
        @Expose
        private List<String> name = null;
        @SerializedName("venue")
        @Expose
        private List<String> venue = null;
        @SerializedName("date")
        @Expose
        private List<String> date = null;
        @SerializedName("start_time")
        @Expose
        private List<String> startTime = null;
        @SerializedName("end_time")
        @Expose
        private List<String> endTime = null;
        @SerializedName("event_id")
        @Expose
        private List<String> eventId = null;

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        public List<String> getCategory() {
            return category;
        }

        public void setCategory(List<String> category) {
            this.category = category;
        }

        public List<String> getName() {
            return name;
        }

        public void setName(List<String> name) {
            this.name = name;
        }

        public List<String> getVenue() {
            return venue;
        }

        public void setVenue(List<String> venue) {
            this.venue = venue;
        }

        public List<String> getDate() {
            return date;
        }

        public void setDate(List<String> date) {
            this.date = date;
        }

        public List<String> getStartTime() {
            return startTime;
        }

        public void setStartTime(List<String> startTime) {
            this.startTime = startTime;
        }

        public List<String> getEndTime() {
            return endTime;
        }

        public void setEndTime(List<String> endTime) {
            this.endTime = endTime;
        }

        public List<String> getEventId() {
            return eventId;
        }

        public void setEventId(List<String> eventId) {
            this.eventId = eventId;
        }


}
