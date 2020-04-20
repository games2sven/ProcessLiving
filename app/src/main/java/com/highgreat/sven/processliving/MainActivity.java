package com.highgreat.sven.processliving;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.highgreat.sven.processliving.activity.KeepManager;
import com.highgreat.sven.processliving.doubleProcess.GuardService;
import com.highgreat.sven.processliving.doubleProcess.LocalService;
import com.highgreat.sven.processliving.doubleProcess.RemoteService;
import com.highgreat.sven.processliving.jobscheduler.MyJobService;
import com.highgreat.sven.processliving.service.ForegroundService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //第一种：1个像素的Acitivty
//        KeepManager.getInstance().registerKeepReceiver(this);
        //第二种：前台Service提高优先级
//        Intent intent = new Intent(this, ForegroundService.class);
//        startActivity(intent);
        //第三种：Jobscheduler 定时任务拉活
//        MyJobService.startJob(this);
        //第四种：双进程守护
        startService(new Intent(this, LocalService.class));
        startService(new Intent(this, RemoteService.class));
        GuardService.startJob(this);
    }
}
