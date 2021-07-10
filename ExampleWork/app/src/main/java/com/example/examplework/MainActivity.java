package com.example.examplework;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    WorkManager manager;
    OneTimeWorkRequest firstRequest;
    PeriodicWorkRequest secondRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresCharging(true).build();
        firstRequest = new OneTimeWorkRequest.Builder(FirstWork.class)
                .setConstraints(constraints)
                .build();
        secondRequest = new PeriodicWorkRequest.Builder(SecondWork.class,15, TimeUnit.MINUTES).build();
    }

    public void start(View view) {
        WorkManager.getInstance(this).enqueue(firstRequest);
        WorkManager.getInstance(this).enqueue(secondRequest);
    }
}