package com.myapplication;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int year_z, month_z, day_z;
    long answer_days, answer_milli;
    static long delta;
    long vac1, vac2, vac3;
    static final int DIALOG_ID = 0;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public void showDialogOn() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Calendar cal = Calendar.getInstance();
        year_z = cal.get(Calendar.YEAR);
        month_z = cal.get(Calendar.MONTH);
        day_z = cal.get(Calendar.DAY_OF_MONTH);
        int i;

        showDialogOn();

        registerReceiver(new MyReceiver(), new IntentFilter());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Enter DOB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                showDialog(DIALOG_ID);


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListener, year_z, month_z, day_z);
        return null;

    }

    public DatePickerDialog.OnDateSetListener dpickerListener =
            new DatePickerDialog.OnDateSetListener() {


                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    int year_x = year;
                    int month_x = monthOfYear + 1;
                    int day_x = dayOfMonth;

                    final Calendar cal = Calendar.getInstance();
                    int year_y = cal.get(cal.YEAR);
                    int month_y = cal.get(cal.MONTH) + 1;
                    int day_y = cal.get(cal.DAY_OF_MONTH);

                    Date date_x = new GregorianCalendar(year_x, month_x, day_x).getTime();
                    Date date_y = new GregorianCalendar(year_y, month_y, day_y).getTime();
                    answer_days = getDateDiffString(date_y, date_x);

                    Toast.makeText(getApplicationContext(), answer_days + " no. of days", Toast.LENGTH_SHORT).show();
                    setAlarm(answer_days);

                }
            };


    public void setAlarm(long x) {

        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent1 = new Intent(MainActivity.this, MyReceiver.class);
        long[] vac = new long[25];
        vac[0] = System.currentTimeMillis() + 50 * 1000; //test
        vac[1] = System.currentTimeMillis() + 1000 * 86400 * 30;     //hepb
        vac[2] = System.currentTimeMillis() + 1000 * 86400 * 58;     //rv
        vac[3] = System.currentTimeMillis() + 1000 * 86400 * 59;    //ditap
        vac[4] = System.currentTimeMillis() + 1000 * 86400 * 60;   //hib
        vac[5] = System.currentTimeMillis() + 1000 * 86400 * 61;   //pcv
        vac[6] = System.currentTimeMillis() + 1000 * 86400 * 62;  //ipv
        vac[7] = System.currentTimeMillis() + 1000 * 86400 * 118;   //rv
        vac[8] = System.currentTimeMillis() + 1000 * 86400 * 119;  //dtap
        vac[9] = System.currentTimeMillis() + 1000 * 86400 * 120;       //hib
        vac[10] = System.currentTimeMillis() + 1000 * 86400 * 121; //pcv
        vac[11] = System.currentTimeMillis() + 1000 * 86400 * 122;     //ipv
        vac[12] = System.currentTimeMillis() + 1000 * 86400 * 178; //rv
        vac[13] = System.currentTimeMillis() + 1000 * 86400 * 179;     //ditap
        vac[14] = System.currentTimeMillis() + 1000 * 86400 * 180;   //hib
        vac[15] = System.currentTimeMillis() + 1000 * 86400 * 181;   //pcv
        vac[16] = System.currentTimeMillis() + 1000 * 86400 * 240;   //hep b
        vac[17] = System.currentTimeMillis() + 1000 * 86400 * 250;     //dtap

        int i;
        if (x < 30) {
            for (i = 0; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);

            }
        } else if (x < 60) {
            for (i = 2; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);
            }

        } else if (x < 120) {
            for (i = 7; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);
            }
        } else if (x < 180) {
            for (i = 12; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);
            }

        } else if (x < 240) {
            for (i = 16; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);
            }
        } else if (x < 250) {
            for (i = 17; i < 18; i++) {
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, i, intent1, 0);
                am.set(AlarmManager.RTC_WAKEUP, vac[i], pIntent);
            }
        }


    }


    public long getDateDiffString(Date dateOne, Date dateTwo) {
        long timeOne = dateOne.getTime();
        long timeTwo = dateTwo.getTime();
        long oneDay = 86400000;
        delta = (timeTwo - timeOne) / oneDay;

        if (delta > 0) {
            return delta;
        } else {
            delta *= -1;
            return delta;
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*  @Override
      public boolean onCreateOptionsMenu(Menu menu) {
          // Inflate the menu; this adds items to the action bar if it is present.
          getMenuInflater().inflate(R.menu.main, menu);
          return true;
      }
  */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_vaccine) {
            Intent intent = new Intent(this, vmenu.class);
            startActivity(intent);
        } else if (id == R.id.nav_mal) {

            Intent intent2 = new Intent(this, Malnutrition.class);
            startActivity(intent2);

        } else if (id == R.id.nav_ratio) {
            Intent intent1 = new Intent(this, Ageratio.class);
            startActivity(intent1);
        }
            else if (id == R.id.nav_nutrients) {
                Intent intent_nutrients = new Intent(this, Nutrition.class);
                startActivity(intent_nutrients);
            }

         else if (id == R.id.nav_exit) {
            finish();
            System.exit(0);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}

