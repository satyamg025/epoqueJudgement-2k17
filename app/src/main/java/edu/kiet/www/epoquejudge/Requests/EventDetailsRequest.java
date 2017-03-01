package edu.kiet.www.epoquejudge.Requests;

import edu.kiet.www.epoquejudge.Models.EventDetailsPOJO;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sooraj on 01-03-2017.
 */

public interface EventDetailsRequest {
    @GET("App_controller/showEvents")
    Call<EventDetailsPOJO> request();
}
