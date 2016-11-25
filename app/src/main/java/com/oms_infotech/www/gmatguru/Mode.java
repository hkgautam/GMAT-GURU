package com.oms_infotech.www.gmatguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class Mode extends AppCompatActivity {
RelativeLayout tv1,tv2;
    Firebase firebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        tv1=(RelativeLayout)findViewById(R.id.rlpractice);
        tv2=(RelativeLayout)findViewById(R.id.rlquiz);

        final String url=getIntent().getExtras().getString("url");
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mode.this,Practice.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Mode.this,DifficultyLevel.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });

    }
}
