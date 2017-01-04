package com.myapplication;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;

public class MyAlarmService extends Service {
    Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    public MyAlarmService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        super.onStart(intent, startId);
        Intent intent1 = new Intent(this.getApplicationContext(), vmenu.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setAutoCancel(true);
        mBuilder.setTicker("It's time for vaccination");
        mBuilder.setContentTitle("VacciMe!");


        String myvaccine;
        myvaccine="HepB";


        mBuilder.setContentText("Time for"+myvaccine+" Vaccination");
                mBuilder.setSmallIcon(R.drawable.botox);
        mBuilder.setSound(sound);
                mBuilder.setContentIntent(pIntent);

        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        mNM.notify(0,mBuilder.build());


        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
