package com.oms_infotech.www.gmatguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Section extends AppCompatActivity {
    RelativeLayout tv1,tv2,tv3,tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);


        tv1=(RelativeLayout) findViewById(R.id.rlmaths);
        tv2=(RelativeLayout) findViewById(R.id.rlreading);
        tv3=(RelativeLayout) findViewById(R.id.rlcritical);
        tv4=(RelativeLayout) findViewById(R.id.rlsentence);
        tv5=(RelativeLayout) findViewById(R.id.rlawa);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Section.this,Mode.class);
                intent.putExtra("url","https://gmat-maths.firebaseio.com/");
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Section.this,Mode.class);
                intent.putExtra("url","https://gmat-maths.firebaseio.com/");
                startActivity(intent);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Section.this,Mode.class);
                intent.putExtra("url","https://gmat-maths.firebaseio.com/");
                startActivity(intent);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Section.this,Mode.class);
                intent.putExtra("url","https://gmat-maths.firebaseio.com//");
                startActivity(intent);
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Section.this,Mode.class);
                intent.putExtra("url","https://gmatsectiona.firebaseio.com/");
                startActivity(intent);
            }
        });

    }
}
