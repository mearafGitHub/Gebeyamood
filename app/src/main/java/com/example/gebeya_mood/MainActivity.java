package com.example.gebeya_mood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.gebeya_mood.Auths.register.OAuthActivity;
import com.example.gebeya_mood.Auths.register.SignUpActivity;
import com.example.gebeya_mood.UserMood.MoodPromptActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, OAuthActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}