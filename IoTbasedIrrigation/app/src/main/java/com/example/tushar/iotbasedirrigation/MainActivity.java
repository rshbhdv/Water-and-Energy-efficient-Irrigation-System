package com.example.tushar.iotbasedirrigation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                Intent intent = new Intent(getApplication(), field.class);
                overridePendingTransition(R.anim.push_out_left, R.anim.push_out_right);
                startActivity(intent);
                finish();

            }
        }, 1500);



    }

    @Override
    public void onStart()
    {
        super.onStart();

    }
}
