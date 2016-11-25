package com.oms_infotech.www.gmatguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishQuiz extends AppCompatActivity {

    TextView tvtotal,tvcorrect,tvwrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_quiz);

        tvtotal=(TextView)findViewById(R.id.textViewtotal);
        tvcorrect=(TextView)findViewById(R.id.textViewcorrect);
        tvwrong=(TextView)findViewById(R.id.textViewwrong);

        tvtotal.setText("Total Questions : "+getIntent().getExtras().getInt("total"));
        tvcorrect.setText("Correct : "+getIntent().getExtras().getInt("correct"));
        tvwrong.setText("Wrong : "+getIntent().getExtras().getInt("wrong"));

    }
}
