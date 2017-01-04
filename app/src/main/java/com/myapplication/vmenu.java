package com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class vmenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vmenu);
    }
    public void hepbint(View view){
        Intent hepb=new Intent(this,HepB.class);
        startActivity(hepb);

    }
    public void dptint(View view){
        Intent dpt=new Intent(this,Dpt.class);
        startActivity(dpt);

    }
    public void haeint(View view){
        Intent hae=new Intent(this,Hae.class);
        startActivity(hae);

    }
    public void polint(View view){
        Intent pol=new Intent(this,Polio.class);
        startActivity(pol);

    }

    public void rotaint(View view){
        Intent rota=new Intent(this,Rota.class);
        startActivity(rota);

    }

    public void inflint(View view){
        Intent infl=new Intent(this,Influ.class);
        startActivity(infl);

    }
    public void mmrint(View view){
        Intent mmr=new Intent(this,Mmr.class);
        startActivity(mmr);

    }

    public void pneint(View view){
        Intent pne=new Intent(this,Pneu.class);
        startActivity(pne);

    }
    public void variint(View view){
        Intent vari=new Intent(this,Varicella.class);
        startActivity(vari);

    }
    public void hepaint(View view){
        Intent hepa=new Intent(this,Hepa.class);
        startActivity(hepa);

    }
}
