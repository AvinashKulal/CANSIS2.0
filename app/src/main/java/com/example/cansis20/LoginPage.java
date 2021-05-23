package com.example.cansis20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {
    private Bundle bundle;
    private Button loginButton,forgetButton;
    private EditText phone,pass;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,MainActivity.class));
            return;
        }


        loginButton = findViewById(R.id.login_btn);
        forgetButton = findViewById(R.id.forgot_btn);
        phone = findViewById(R.id.phone_number);
        pass = findViewById(R.id.password);


        bundle = getIntent().getExtras();
        loginButton.setText(bundle.getString("TypeOfLogin"));
        forgetButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");


    }

    private void studentLogin() {
        Toast.makeText(this,"In",Toast.LENGTH_SHORT).show();

        final String phonenumber = phone.getText().toString().trim();
        final String password = pass.getText().toString().trim();

        progressDialog.show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST, Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {

                           JSONObject jsonobj = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                                if(!jsonobj.getBoolean("error")) {
                                    SharedPrefManager.getInstance(getApplicationContext()).userLogin(




                                      jsonobj.getString("name"),
                                      jsonobj.getString("phone"),
                                            jsonobj.getString("address"),
                                            jsonobj.getString("email"),
                                            jsonobj.getString("mothers_name"),
                                            jsonobj.getString("mothers_no"),
                                            jsonobj.getString("branch"),
                                            jsonobj.getString("year"),
                                            jsonobj.getString("image"),
                                            jsonobj.getString("stud_id")



                                    );


                                    //NOTIFICATION


                                    //NOTIFICATION end here



                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent);
                                    //finish();
                                }else
                                Toast.makeText(getApplicationContext(),jsonobj.getString("message"),Toast.LENGTH_SHORT).show();


                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage()+"Volley error",Toast.LENGTH_SHORT).show();
       
            }
        }


        ){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //Toast.makeText(getApplicationContext(),"out",Toast.LENGTH_SHORT).show();

                Map<String,String> params = new HashMap<>();
                params.put("phone_number",phonenumber);
                System.out.println("This is map function");
                params.put("password",password);
                return params;

            }
        };
        RequestHandler.getInstance(this).addToRequestQueue(stringRequest);


    }


    private void parentLogin() {

    }




    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.login_btn:
                if(bundle.getString("TypeOfLogin").equals("STUDENT LOGIN")){
                    studentLogin();

                }else if(bundle.getString("TypeOfLogin").equals("PARENT LOGIN")) {
                    parentLogin();


                }

                break;

            case R.id.forgot_btn:
                intent = new Intent(this,ForgotPassword.class);
                startActivity(intent);
                break;

        }
    }




}
