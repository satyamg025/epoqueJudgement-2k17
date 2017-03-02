package edu.kiet.www.epoquejudge.Activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.kiet.www.epoquejudge.Models.LoginPOJO;
import edu.kiet.www.epoquejudge.R;
import edu.kiet.www.epoquejudge.Requests.LoginRequest;
import edu.kiet.www.epoquejudge.networking.NetworkCheck;
import edu.kiet.www.epoquejudge.networking.ServiceGenerator;
import edu.kiet.www.epoquejudge.ui.coloredSnackBar;
import edu.kiet.www.epoquejudge.util.DbHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    Button login;
    EditText username,password;
    TextInputLayout user_layout,pass_layout;
    Boolean doubleBackToExitPressedOnce=false;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            login();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button)findViewById(R.id.login);
        //logintxt=(TextView)parentView.findViewById(R.id.login_text);


        username=(EditText)findViewById(R.id.input_roll);
        password=(EditText)findViewById(R.id.input_password);
        user_layout=(TextInputLayout) findViewById(R.id.input_roll_layout);
        pass_layout=(TextInputLayout) findViewById(R.id.input_password_layout);

        username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_layout.isErrorEnabled() && pass_layout.isErrorEnabled()){
                    user_layout.setErrorEnabled(false);
                    pass_layout.setErrorEnabled(false);
                }
                else if(user_layout.isErrorEnabled()){
                    user_layout.setErrorEnabled(false);
                }
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_layout.isErrorEnabled() && pass_layout.isErrorEnabled()){
                    user_layout.setErrorEnabled(false);
                    pass_layout.setErrorEnabled(false);
                }
                else if(pass_layout.isErrorEnabled()){
                    pass_layout.setErrorEnabled(false);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }

        });

    }


    public void login(){

        if(username.getText().toString().equals("") && password.getText().toString().equals("")){
            user_layout.setError("Please enter username");
            pass_layout.setError("Please enter password");
        }
        else if(username.getText().toString().equals("")){
            user_layout.setError("Please enter username");
        }
        else if(password.getText().toString().equals("")){
            pass_layout.setError("Please enter password");
        }

        else {

            if (!NetworkCheck.isNetworkAvailable(Login.this)) {

                Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "No network connection", Snackbar.LENGTH_LONG)
                        .setAction("Retry", mSnackBarClickListener);
                coloredSnackBar.alert(snackbar).show();
                return;
            } else {
                final ProgressDialog progressDialog = new ProgressDialog(Login.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setCancelable(false);
                progressDialog.setMessage("Authenticating...");
                progressDialog.show();
//                Log.e("fcm_id", FirebaseInstanceId.getInstance().getToken());

                LoginRequest loginRequest = ServiceGenerator.createService(LoginRequest.class, username.getText().toString(), password.getText().toString());
                Call<LoginPOJO> call = loginRequest.responseRequest();
                call.enqueue(new Callback<LoginPOJO>() {
                    @Override
                    public void onResponse(Call<LoginPOJO> call, Response<LoginPOJO> response) {
                        LoginPOJO responseBody = response.body();
                        progressDialog.dismiss();
                        Log.e("Login_data", String.valueOf(responseBody) + " " + String.valueOf(response.code()));
                        if (response.code() == 200) {
                            if (!responseBody.getError()) {

                                DbHandler.setSession(Login.this, responseBody.getKey(), responseBody.getPerson());
                                DbHandler.putBoolean(Login.this,"isForcedLoggedOut",false);
                                DbHandler.putString(Login.this,"judge_name",responseBody.getName());
                                startActivity(new Intent(Login.this, Dashboard.class));
                            } else {
                                new AlertDialog.Builder(Login.this)
                                        .setTitle("Failed")
                                        .setMessage("Login Failed")
                                        .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {
                                                onBackPressed();

                                            }
                                        })
                                        .show();
                            }
                        } else {
                            new AlertDialog.Builder(Login.this)
                                    .setTitle("Failed")
                                    .setMessage("Failed to connect")
                                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                           onBackPressed();
                                        }
                                    })
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginPOJO> call, Throwable t) {
                        progressDialog.dismiss();
                        new AlertDialog.Builder(Login.this)
                                .setMessage("Connection Failed")
                                .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        login();
                                    }
                                })
                                .show();

                    }
                });
            }
        }

    }

    @Override
    public void onBackPressed(){

            if (doubleBackToExitPressedOnce) {
                this.finishAffinity();
                return;
            }

            this.doubleBackToExitPressedOnce = true;

            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),"Press again to exit", Snackbar.LENGTH_SHORT);
            coloredSnackBar.warning(snackbar).show();
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
        // super.onBackPressed();




}

