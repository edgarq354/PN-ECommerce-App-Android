/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

package com.hitesh_sahu.retailapp.view.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hitesh_sahu.retailapp.R;


public class Destino extends AppCompatActivity   {


    Toolbar toolbar;
EditText et_latitud;
EditText et_longitud;

Button bt_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        et_latitud= (EditText) findViewById(R.id.et_latitud);
        et_longitud= (EditText) findViewById(R.id.et_longitud);
        bt_buscar= (Button) findViewById(R.id.bt_buscar);


        bt_buscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                double lat= Double.parseDouble(et_latitud.getText().toString());
                double lon= Double.parseDouble(et_longitud.getText().toString());

                    Uri gmmIntentUri = Uri.parse("google.navigation:q="+lat+","+lon);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);

            }
        });



    }



}
