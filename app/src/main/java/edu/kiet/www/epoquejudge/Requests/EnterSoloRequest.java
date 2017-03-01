package edu.kiet.www.epoquejudge.Requests;

import edu.kiet.www.epoquejudge.Models.EnterMarksPOJO;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sooraj on 28-02-2017.
 */

public interface EnterSoloRequest {
    @FormUrlEncoded
    @POST("App_controller/enter_solo")
    Call<EnterMarksPOJO> request(@Field("lib_id")String lib_id, @Field("event_id") String event_id, @Field("attr_id") String attr_id, @Field("marks") String marks);
}
