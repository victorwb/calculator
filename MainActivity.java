package com.example.differntiation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //refrences to variables

   Button  btn_compute;
   EditText et_function, et_age;
   Switch sw_active;
   ListView lv;
   String answer;
   TextView link_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_function = findViewById(R.id.et_name);
        sw_active = findViewById(R.id.sw_active);
        btn_compute = findViewById(R.id.btn_compute);
        link_tv = findViewById(R.id.textView2);
        //lv = findViewById(R.id.lv1);
        //FunctionModel functionModel;
        //listeners
        btn_compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FunctionModel functionModel = new FunctionModel(et_function.getText().toString(),sw_active.isChecked());
                answer = functionModel.calculate();
                Toast.makeText(MainActivity.this,answer, Toast.LENGTH_SHORT).show();
            }
        });

        link_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });
    }

}