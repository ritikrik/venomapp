package com.example.loginapp;



import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Main2Activity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private Button buttonSignIn;
    private EditText editTextEmail;
    private Button btnn;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//Noti
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel("MyNotification", "MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);


        }
        //yahan tak
        editTextEmail = (EditText) findViewById(R.id.name);
        btnn=(Button) findViewById(R.id.btnn);
        editTextPassword = (EditText) findViewById(R.id.pass);
        buttonSignIn = (Button) findViewById(R.id.button);
        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view==btnn)
                {
                    Intent intent=new Intent(Main2Activity.this, Main4Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }
    private void validate(String name1, String pass1) {

        if (TextUtils.isEmpty(name1)) {
            Toast.makeText(this, "Please enter name", Toast.LENGTH_SHORT).show();

                    }
        if (TextUtils.isEmpty(pass1)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }

            if ((name1.equals("admin")) && (pass1.equals("admin"))) {
                Intent intent = new Intent(Main2Activity.this, Main4Activity.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(this, "Incorrect Please Try Again", Toast.LENGTH_SHORT).show();
            }

        }

    @Override
    public void onBackPressed() {


        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            finish();
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();


        }
        backPressedTime = System.currentTimeMillis();

    }
}

