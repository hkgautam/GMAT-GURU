package com.oms_infotech.www.gmatguru;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Random;

public class Quiz extends AppCompatActivity {

    int i,correct=0,wrong=0,total=0;
    String level,number;
    RadioGroup radioGroup;
    TextView tvque;
    Firebase firebase;
    String selection;
    RadioButton opt1, opt2, opt3, opt4, radioButton;
    Button btnsubmit,btnnext;
    TextView tvtime;
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        tvtime=(TextView)findViewById(R.id.textViewtime);

        tvque = (TextView) findViewById(R.id.tvque100);

        opt1 = (RadioButton) findViewById(R.id.opt1100);
        opt2 = (RadioButton) findViewById(R.id.opt2100);
        opt3 = (RadioButton) findViewById(R.id.opt3100);
        opt4 = (RadioButton) findViewById(R.id.opt4100);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup100);
        btnsubmit = (Button) findViewById(R.id.buttonsubmit100);

        number=getIntent().getExtras().getString("number");
        tvtime.setText(number);
        level=getIntent().getExtras().getString("level");
        String url = getIntent().getExtras().getString("url");
        firebase = new Firebase(url);
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                Random r = new Random();
                String node= (String) dataSnapshot.child("TotalQues").getValue();
                i = r.nextInt(Integer.valueOf(node)) + 1;

                tvque.setText((String) dataSnapshot.child("Que" + i).getValue());
                opt1.setText((String) dataSnapshot.child("Opt" + i + "1").getValue());
                opt2.setText((String) dataSnapshot.child("Opt" + i + "2").getValue());
                opt3.setText((String) dataSnapshot.child("Opt" + i + "3").getValue());
                opt4.setText((String) dataSnapshot.child("Opt" + i + "4").getValue());

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selectedId);
                        String str = radioButton.getText().toString();

                        if (str.equals(dataSnapshot.child("Ans" + i).getValue())) {
                            correct=correct+1;
                            total=total+1;
                        } else {
                            wrong=wrong+1;
                            total=total+1;
                        }

                        if(total==Integer.valueOf(number)){
                            btnsubmit.setText("Finish");
                            Intent intent=new Intent(Quiz.this,FinishQuiz.class);
                            intent.putExtra("correct",correct);
                            intent.putExtra("wrong",wrong);
                            intent.putExtra("total",total);
                            startActivity(intent);
                        }
                        next();

                    }
                });

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });








        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, SPLASH_TIME_OUT);

    }
    void next() {
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                Random r = new Random();
                String node= (String) dataSnapshot.child("TotalQues").getValue();
                i = r.nextInt(Integer.valueOf(node)) + 1;
                tvque.setText((String) dataSnapshot.child("Que" + i).getValue());
                opt1.setText((String) dataSnapshot.child("Opt" + i + "1").getValue());
                opt2.setText((String) dataSnapshot.child("Opt" + i + "2").getValue());
                opt3.setText((String) dataSnapshot.child("Opt" + i + "3").getValue());
                opt4.setText((String) dataSnapshot.child("Opt" + i + "4").getValue());

                btnsubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selectedId);
                        String str = radioButton.getText().toString();

                        if (str.equals(dataSnapshot.child("Ans" + i).getValue())) {
                            correct=correct+1;
                            total=total+1;
                        } else {
                            wrong=wrong+1;
                            total=total+1;
                        }
                        if(total==Integer.valueOf(number)-1)
                        {
                            btnsubmit.setText("Finish");
                        }
                        if(total==Integer.valueOf(number)){
                            Intent intent=new Intent(Quiz.this,FinishQuiz.class);
                            intent.putExtra("correct",correct);
                            intent.putExtra("wrong",wrong);
                            intent.putExtra("total",total);
                            startActivity(intent);
                        }
                        next();

                    }
                });

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
