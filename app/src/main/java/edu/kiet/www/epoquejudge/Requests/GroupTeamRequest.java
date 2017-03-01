package edu.kiet.www.epoquejudge.Requests;

import edu.kiet.www.epoquejudge.Models.GetGroupTeamsPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by satyam on 3/1/17.
 */
public interface GroupTeamRequest {
    @GET("App_controller/showEventTeams")
    Call<GetGroupTeamsPOJO> request(@Query("event_id") String eid);
}
