package edu.kiet.www.epoquejudge.Requests;

import edu.kiet.www.epoquejudge.Models.LoginPOJO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by satyam on 2/28/17.
 */
public interface LoginRequest {
    @GET("App_controller/login_epk")
    Call<LoginPOJO> responseRequest();
}
