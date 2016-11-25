package com.oms_infotech.www.gmatguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.logging.Level;

public class DifficultyLevel extends AppCompatActivity {

    ListView lv;
    Button btnstart;
    TextView tvlevel;
    EditText ed;
    String[] levels={"Easy", "Medium", "Difficult"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_level);

        tvlevel=(TextView)findViewById(R.id.textViewlevel);
        btnstart=(Button)findViewById(R.id.buttonstart);
        ed=(EditText)findViewById(R.id.editText);

        lv=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,levels);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tvlevel.setText(levels[i]);
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DifficultyLevel.this,Quiz.class);
                intent.putExtra("level",tvlevel.getText());
                intent.putExtra("number",ed.getText().toString());
                intent.putExtra("url",getIntent().getExtras().getString("url"));
                startActivity(intent);
            }
        });



    }
}
