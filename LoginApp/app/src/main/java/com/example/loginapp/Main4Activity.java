package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
private CardView one,two,three,four,five,six;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main4);
        one =(CardView) findViewById(R.id.one);
        two =(CardView) findViewById(R.id.two);
        three =(CardView) findViewById(R.id.three);
        four =(CardView) findViewById(R.id.four);
        five =(CardView) findViewById(R.id.five);
        six =(CardView) findViewById(R.id.six);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId())
        {
            case R.id.one:i= new Intent(this,Event.class);

                startActivity(i);
              //  overridePendingTransition(R.anim.fadein,R.anim.fadeout);

            break;
            case R.id.two:i= new Intent(this,Schedule.class); startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                break;
            case R.id.three:i= new Intent(this,Speaker.class);startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            break;
            case R.id.four:i= new Intent(this,Sponsor.class);startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            break;
            case R.id.five:i= new Intent(this,Team.class);startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            break;
            case R.id.six:i= new Intent(this,Faq.class);startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            break;
            default:break;
        }

    }
}
