package com.example.campusexpensese06206;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleSecondActivity extends AppCompatActivity {
    Button btnBackActivity;
    TextView tvIdStudent, tvNameStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_second);
        btnBackActivity = findViewById(R.id.btnBackActivity);
        tvIdStudent = findViewById(R.id.tvIDStudent);
        tvNameStudent = findViewById(R.id.tvFullName);

        // lay du lieu tu LifeCycle Activity truyen sang
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            int id = bundle.getInt("ID_STUDENT",0);
            String name = bundle.getString("NAME_STUDENT", "");
            tvIdStudent.setText(String.valueOf(id));
            tvNameStudent.setText(name);
        }

        btnBackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleSecondActivity.this, LifeCycleActivity.class);
                startActivity(intent);
            }
        });
    }
}
