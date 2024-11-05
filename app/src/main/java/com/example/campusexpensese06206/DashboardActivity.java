package com.example.campusexpensese06206;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DashboardActivity extends AppCompatActivity {
    TextView tvUsername;
    EditText edtPhoneNumber, edtUrl;
    Button btnCallPhone, btnLoadUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvUsername = findViewById(R.id.tvUsername);
        edtPhoneNumber = findViewById(R.id.edtPhone);
        btnCallPhone = findViewById(R.id.btnCallPhone);
        edtUrl = findViewById(R.id.edtUrl);
        btnLoadUrl = findViewById(R.id.btnLoadUrl);

        btnLoadUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edtUrl.getText().toString().trim();
                if (TextUtils.isEmpty(url)){
                    edtUrl.setError("URL can be not empty");
                    return;
                }
                // load noi dung website
                Intent intent3 = new Intent(Intent.ACTION_VIEW);
                intent3.setData(Uri.parse(url));
                startActivity(intent3);
            }
        });

        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhoneNumber.getText().toString().trim();
                if (TextUtils.isEmpty(phone)){
                    edtPhoneNumber.setError("Phone number can be not empty");
                    return;
                }
                // thuc hien call phone(goi dien thoai toi 1 so bat ky)
                Intent intent2 = new Intent(Intent.ACTION_CALL);
                intent2.setData(Uri.parse("tel:" + phone));
                if(ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                    startActivity(intent2);
                } else {
                    requestPermissions(new String[]{ CALL_PHONE }, 1);
                }
            }
        });

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            String user = bundle.getString("USERNAME", "");
            tvUsername.setText(user);
        }
    }
}
