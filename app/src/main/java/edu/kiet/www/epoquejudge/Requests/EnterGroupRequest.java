package edu.kiet.www.epoquejudge.Requests;

import edu.kiet.www.epoquejudge.Models.EnterMarksPOJO;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by sooraj on 01-03-2017.
 */

public interface EnterGroupRequest {
    @FormUrlEncoded
    @POST("App_controller/enter_group")
    Call<EnterMarksPOJO> request(@Field("group_id")String lib_id, @Field("event_id") String event_id, @Field("attr_id") String attr_id, @Field("marks") String marks);

}
