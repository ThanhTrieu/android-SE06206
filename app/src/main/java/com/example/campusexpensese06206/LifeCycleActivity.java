package com.example.campusexpensese06206;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifeCycleActivity extends AppCompatActivity {
    private final String LOG_TAG = "LifeCycleActivity";
    Button btnGotoActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ham nay giup tao ra 1 activity
        // day la noi load view giao dien man hinh
        setContentView(R.layout.activity_life_cycle);
        btnGotoActivity = findViewById(R.id.btnGotoActivity);
        // ghi log
        Log.i(LOG_TAG, "***** onCreate is running ******");
        // bat su kien - di chuyen sang man hinh Activity khac
        btnGotoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeCycleActivity.this, LifeCycleSecondActivity.class);
                // su dung doi tuong Bundle de gui du lieu
                Bundle bundle = new Bundle();
                bundle.putInt("ID_STUDENT", 101);
                bundle.putString("NAME_STUDENT", "Nguyen Thanh Trieu");
                intent.putExtras(bundle); // gui du lieu tap tin di
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "***** onStart is Running *******");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG,"***** onResume is Running *******");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG,"***** onPause is Running *******");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG,"***** onStop is Running *******");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG,"***** onRestart is Running *******");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG,"***** onDestroy is Running *******");
    }
}
