package com.example.tushar.iotbasedirrigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class field extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_layout);

        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layout1);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float x=motionEvent.getX();
                float y=motionEvent.getY();
                String s=String.valueOf(x);
                String e=String.valueOf(y);

                Log.d("x",s);
                Log.d("y",e);

                if(y<900)
                {
                    Toast.makeText(getApplicationContext(),"Upper half",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Lower half",Toast.LENGTH_LONG).show();
                }



                return false;
            }
        });
       /* ImageView imageView=(ImageView)findViewById(R.id.fieldlayout);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float x=motionEvent.getX();
                float y=motionEvent.getY();
                String s=String.valueOf(x);
                String e=String.valueOf(y);

                Log.d("x",s);
                Log.d("y",e);

                if(y<900)
                {
                    Toast.makeText(getApplicationContext(),"Upper half",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Lower half",Toast.LENGTH_LONG).show();
                }

                return false;
            }
        });*/


    }
}
