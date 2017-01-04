package com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class malnutrition1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.malnutrition1);
    }

    public void preint(View view) {
        Intent pre = new Intent(this, Malnutrition.class);
        startActivity(pre);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Malnutrition.class);
        startActivity(intent);
        return ;
    }
}