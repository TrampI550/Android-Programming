package com.example.lab5_2try;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import java.util.concurrent.TimeUnit;

public class NotificationService extends Service {
    public final String ACTION_PLUS = "action_plus";
    public final String ACTION_MINUS = "action_minus";
    private int score = 0;
    public final String BROADCAST_ACTION = "com.example.lab5_2tryservicebackbroadcast";
    NotificationManager nm;
    public NotificationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("HEEEEEEEEEEEEEEEEr");
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        score = intent.getIntExtra("score", 0);
        SendNoti(score);
        return super.onStartCommand(intent, flags, startId);
    }

    private void SendNoti(int score) {
        Intent plusIntent = new Intent(this, TaskList.class);
        plusIntent.putExtra(ACTION_PLUS, 1);
        plusIntent.putExtra(ACTION_MINUS, 0);
        PendingIntent plusPendingIntent = PendingIntent.getBroadcast(this, 0, plusIntent, 0);

        Intent minusIntent = new Intent(this, TaskList.class);
        minusIntent.putExtra(ACTION_PLUS, 0);
        minusIntent.putExtra(ACTION_MINUS, 1);
        PendingIntent minusPendingIntent = PendingIntent.getBroadcast(this, 0, minusIntent, 0);

        Notification noti = new NotificationCompat.Builder(this)
                .setContentTitle("Scorer")
                .setContentText(Integer.toString(score))
                .addAction(R.drawable.ic_plus, "plus", plusPendingIntent)
                .addAction(R.drawable.ic_minus, "minus", minusPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
        nm.notify(0, noti);
    }



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}