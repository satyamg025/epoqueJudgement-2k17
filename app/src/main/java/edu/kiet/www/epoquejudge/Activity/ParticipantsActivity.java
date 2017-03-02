package edu.kiet.www.epoquejudge.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;



import java.util.List;

import edu.kiet.www.epoquejudge.Adapter.ParticipantsAdapter;
import edu.kiet.www.epoquejudge.Adapter.ParticipantsAdapterGroup;
import edu.kiet.www.epoquejudge.Models.GetGroupTeamsPOJO;
import edu.kiet.www.epoquejudge.Models.GetSoloTeamsPOJO;
import edu.kiet.www.epoquejudge.R;
import edu.kiet.www.epoquejudge.Requests.GroupTeamRequest;
import edu.kiet.www.epoquejudge.Requests.SoloTeamsRequest;
import edu.kiet.www.epoquejudge.networking.ServiceGenerator;
import edu.kiet.www.epoquejudge.util.DbHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shrey on 28/2/17.
 */

public class ParticipantsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ParticipantsAdapter adapter;
    ParticipantsAdapterGroup adapter2;
    ProgressDialog progressDialog;
    List<String> eventName,participants_group,participants_solo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participants);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Participations");
        setTitleColor(getResources().getColor(R.color.white));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        if(getIntent().getExtras().getString("category","").equals("S")) {
            progressDialog=new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            progressDialog.show();


            SoloTeamsRequest request = ServiceGenerator.createService(SoloTeamsRequest.class, DbHandler.getString(this, "bearer", ""));
            Log.e("requestlog", String.valueOf(request));
            Call<GetSoloTeamsPOJO> call = request.request(getIntent().getExtras().getString("event_id"));
            Log.e("calllog", String.valueOf(call));
            call.enqueue(new Callback<GetSoloTeamsPOJO>() {
                @Override
                public void onResponse(Call<GetSoloTeamsPOJO> call, Response<GetSoloTeamsPOJO> response) {

                    progressDialog.dismiss();
                    if (response.code() == 200) {
                            recyclerView = (RecyclerView) findViewById(R.id.participants_recycler_view);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            adapter = new ParticipantsAdapter(getApplicationContext(), response.body());
                            recyclerView.setAdapter(adapter);

                    } else {
                        progressDialog.dismiss();
                        new AlertDialog.Builder(ParticipantsActivity.this)
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
                public void onFailure(Call<GetSoloTeamsPOJO> call, Throwable t) {
                    progressDialog.dismiss();
                    new AlertDialog.Builder(ParticipantsActivity.this)
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
        else if(getIntent().getExtras().getString("category","").equals("G")){
            progressDialog=new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            GroupTeamRequest request = ServiceGenerator.createService(GroupTeamRequest.class, DbHandler.getString(this, "bearer", ""));
            Log.e("requestlog", String.valueOf(request));
            Call<GetGroupTeamsPOJO> call = request.request(getIntent().getExtras().getString("event_id"));
            Log.e("calllog", String.valueOf(call));
            call.enqueue(new Callback<GetGroupTeamsPOJO>() {
                @Override
                public void onResponse(Call<GetGroupTeamsPOJO> call, Response<GetGroupTeamsPOJO> response) {

                    progressDialog.dismiss();
                    if (response.code() == 200) {
                        recyclerView = (RecyclerView) findViewById(R.id.participants_recycler_view);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ParticipantsActivity.this);
                        recyclerView.setHasFixedSize(false);
                        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        adapter2 = new ParticipantsAdapterGroup(getApplicationContext(), response.body());
                        recyclerView.setAdapter(adapter2);

                    } else {
                        progressDialog.dismiss();
                        new AlertDialog.Builder(ParticipantsActivity.this)
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
                public void onFailure(Call<GetGroupTeamsPOJO> call, Throwable t) {
                    progressDialog.dismiss();
                    new AlertDialog.Builder(ParticipantsActivity.this)
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

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if(id==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}