package com.example.campusexpensese06206;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnSignIn;
    TextView tvSignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout_login);
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen sang man hinh dang ky tai khoan
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String password = edtPass.getText().toString().trim();
                if (TextUtils.isEmpty(user)){
                    edtUser.setError("Username can be not empty");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edtPass.setError("Password can be not empty");
                    return;
                }

                // doc du lieu tu file trong local storage de kiem tra thong tin tai khoan
                try {
                    FileInputStream fileInputStream = openFileInput("user.txt");
                    int read = -1;
                    StringBuilder builder = new StringBuilder();
                    while ((read = fileInputStream.read()) != -1){
                        builder.append((char) read);
                    }
                    fileInputStream.close();
                    // toan bo du lieu cua file duoc doc(luu) vao trong bien builder
                    // can xu ly de kiem tra xem tai khoan ma nguoi dung dang nhap
                    // co nam trong du lieu cua file hay ko?
                    boolean checkLogin = false;
                    String[] infoAccount = null;
                    infoAccount = builder.toString().trim().split("\n");
                    // duyet mang
                    for (String account : infoAccount){
                        String username = account.substring(0,account.indexOf("|")).trim();
                        String pass = account.substring(account.indexOf("|")+1).trim();
                        if (username.equals(user) && pass.equals(password)){
                            // dang nhap thanh cong
                            checkLogin = true;
                            break;
                        }
                    }
                    if (checkLogin){
                        // dang nhap thanh cong
                        Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("USERNAME", user);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        finish(); // khong cho phep lai quay tro lai activity
                    } else {
                        // dang nhap that bai
                        Toast.makeText(LoginActivity.this, "Account Invalid", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
