package com.example.cansis20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WelcomePage extends AppCompatActivity implements View.OnClickListener {
    private Button studentLogin,parentLogin,vision,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);





        studentLogin = findViewById(R.id.student_login);
        parentLogin = findViewById(R.id.parent_login);
        vision = findViewById(R.id.vision);
        about = findViewById(R.id.about);
        studentLogin.setOnClickListener(this);
        parentLogin.setOnClickListener(this);
        vision.setOnClickListener(this);
        about.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){

            case R.id.student_login:
                intent = new Intent(this,LoginPage.class);
                intent.putExtra("TypeOfLogin","STUDENT LOGIN");
                startActivity(intent);
                break;
            case R.id.parent_login:
                intent = new Intent(this,LoginPage.class);
                intent.putExtra("TypeOfLogin","PARENT LOGIN");
                startActivity(intent);
                break;
            case R.id.vision:
                intent = new Intent(this,VisionMission.class);
                startActivity(intent);

                break;
            case R.id.about:
                intent = new Intent(this,AboutCollege.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(getApplicationContext(),"Action not set",Toast.LENGTH_SHORT).show();

        }
    }
}
