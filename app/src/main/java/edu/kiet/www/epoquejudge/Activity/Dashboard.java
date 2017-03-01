package edu.kiet.www.epoquejudge.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import java.util.List;

import edu.kiet.www.epoquejudge.Adapter.EventsAdapter;
import edu.kiet.www.epoquejudge.Models.EventDetailsDataPOJO;
import edu.kiet.www.epoquejudge.Models.EventDetailsPOJO;
import edu.kiet.www.epoquejudge.R;
import edu.kiet.www.epoquejudge.Requests.EventDetailsRequest;
import edu.kiet.www.epoquejudge.networking.ServiceGenerator;
import edu.kiet.www.epoquejudge.ui.coloredSnackBar;
import edu.kiet.www.epoquejudge.util.DbHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {
RecyclerView recyclerView;
    ProgressDialog progressDialog;
    EventsAdapter adapter;
    List<String> eventName,type,category,venue,schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Dashboard");
        setTitleColor(getResources().getColor(R.color.white));

        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();


// Initialize Stetho with the Initialize

        final EventDetailsRequest request= ServiceGenerator.createService(EventDetailsRequest.class, DbHandler.getString(this,"bearer",""));
        Call<EventDetailsPOJO> call=request.request();
        call.enqueue(new Callback<EventDetailsPOJO>() {

                         @Override
                         public void onResponse(Call<EventDetailsPOJO> call, Response<EventDetailsPOJO> response) {
                             if(response.code()==200){
                                 if(!response.body().getError()){
                                     progressDialog.dismiss();
                                     EventDetailsDataPOJO data=response.body().getData();
                                     recyclerView=(RecyclerView)findViewById(R.id.event_details);
                                     LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                                     linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                                     recyclerView.setLayoutManager(linearLayoutManager);
                                     adapter=new EventsAdapter(getApplicationContext(),data);
                                     recyclerView.setAdapter(adapter);

                                 }
                                 else {
                                     Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Session Expired", Snackbar.LENGTH_LONG);
                                     coloredSnackBar.alert(snackbar).show();
                                     DbHandler.unsetSession(Dashboard.this, "isForcedLoggedOut");
                                 }
                             } else {
                                 progressDialog.dismiss();
                                 new AlertDialog.Builder(Dashboard.this)
                                         .setTitle("Failed")
                                         .setMessage("Failed to connect")
                                         .setNegativeButton("Ok", new DialogInterface.OnClickListener() {

                                             @Override
                                             public void onClick(DialogInterface dialogInterface, int i) {
                                                 onBackPressed();
                                             }
                                         })
                                         .show();
                             }
                         }
                         @Override
                         public void onFailure(Call<EventDetailsPOJO> call, Throwable t) {
                             progressDialog.dismiss();
                             new AlertDialog.Builder(Dashboard.this)
                                     .setMessage("Connection failed")
                                     .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                         public void onClick(DialogInterface dialog, int which) {
                                             onBackPressed();
                                         }
                                     })
                                     .show();

                         }


                     });
    }
    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(Dashboard.this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to Logout?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        DbHandler.unsetSession2(Dashboard.this, "isLoggedOut");
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }
}
