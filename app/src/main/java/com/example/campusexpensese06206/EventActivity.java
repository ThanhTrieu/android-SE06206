package com.example.campusexpensese06206;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {
    CheckBox cbAgree;
    EditText edtData;
    TextView tvCount, tvData, tvGender;
    RadioGroup radioGroupGender;
    Button btnClickMe;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        // anh xa view
        cbAgree = findViewById(R.id.cbAgree);
        edtData = findViewById(R.id.edtData);
        tvCount = findViewById(R.id.tvCountData);
        tvData = findViewById(R.id.tvData);
        radioGroupGender = findViewById(R.id.radGroupGender);
        btnClickMe = findViewById(R.id.btnClickMe);
        tvGender = findViewById(R.id.tvGender);

        //block EditText
        edtData.setEnabled(false);
        // bat su kien vs checkbox
        cbAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    edtData.setEnabled(true);
                } else {
                    edtData.setEnabled(false);
                    edtData.setText("");
                }
            }
        });
        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String data = s.toString().trim();
                int count = data.length();
                tvData.setText(data);
                tvCount.setText(String.valueOf(count));
            }
        });
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton rad = (RadioButton) findViewById(selectedId);
                String gender = rad.getText().toString().trim();
                tvGender.setText("Your gender is " + gender);
                if (gender.equals("Others")){
                    edtData.setEnabled(true);
                } else {
                    edtData.setEnabled(false);
                }
                Toast.makeText(EventActivity.this, gender, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
