package com.oms_infotech.www.gmatguru;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
import com.firebase.client.snapshot.Index;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practice extends AppCompatActivity {

    int i;
    RadioGroup radioGroup;
    TextView tvque, tvans, tvcorr, tv15;
    Firebase firebase;
    String selection;
    RadioButton opt1, opt2, opt3, opt4, radioButton;
    Button btnsubmit,btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        tvque = (TextView) findViewById(R.id.tvque);
        tvans = (TextView) findViewById(R.id.tvans);
        tvcorr = (TextView) findViewById(R.id.tvcorr);
        tv15 = (TextView) findViewById(R.id.textView15);

        opt1 = (RadioButton) findViewById(R.id.opt1);
        opt2 = (RadioButton) findViewById(R.id.opt2);
        opt3 = (RadioButton) findViewById(R.id.opt3);
        opt4 = (RadioButton) findViewById(R.id.opt4);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        btnsubmit = (Button) findViewById(R.id.buttonsubmit);
        btnnext=(Button)findViewById(R.id.btnnext);

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
                            tvcorr.setText("CORRECT !");
                            tvcorr.setTextColor(Color.parseColor("#2CD100"));

                        } else {
                            tvcorr.setText("WRONG CHOICE !");
                            tvcorr.setTextColor(Color.parseColor("#E90000"));
                        }
                        tvans.setText((String) dataSnapshot.child("Ans" + i).getValue());
                        tv15.setText("Answer :");
                    }
                });

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
                tv15.setText("");
                tvcorr.setText("");
                tvans.setText("");
            }
        });


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
                            tvcorr.setText("CORRECT !");
                            tvcorr.setTextColor(Color.parseColor("#2CD100"));

                        } else {
                            tvcorr.setText("WRONG CHOICE !");
                            tvcorr.setTextColor(Color.parseColor("#E90000"));
                        }
                        tvans.setText((String) dataSnapshot.child("Ans" + i).getValue());
                        tv15.setText("Answer :");

                    }
                });

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}