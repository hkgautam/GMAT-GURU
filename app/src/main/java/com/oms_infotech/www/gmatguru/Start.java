package com.oms_infotech.www.gmatguru;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Start extends AppCompatActivity {
    Button buttonstart;
    ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Window window = this.getWindow();
        bar=getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009661")));
        window.setStatusBarColor(Color.parseColor("#008958"));

        buttonstart=(Button)findViewById(R.id.buttonstart);
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Start.this,Section.class);
                startActivity(intent);
            }
        });

    }
}
