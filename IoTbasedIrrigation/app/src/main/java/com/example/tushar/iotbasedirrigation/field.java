package com.example.tushar.iotbasedirrigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class field extends AppCompatActivity {

    Field_Object object;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_layout);

        object=new Field_Object();

        InitialLayout fragment2=new InitialLayout();
        getFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment2).commit();


        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.layout1);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                i=1;
                float x=motionEvent.getX();
                float y=motionEvent.getY();
                String s=String.valueOf(x);
                String e=String.valueOf(y);

                Log.d("x",s);
                Log.d("y",e);


                if(x < 365 && y < 565)
                    getIntent().putExtra("FObject", 0);

                else if(x < 730 && y < 565)
                    getIntent().putExtra("FObject", 1);

                else if(x < 1100 && y < 565)
                    getIntent().putExtra("FObject", 2);

                else if(x < 365 && y < 1130)
                    getIntent().putExtra("FObject", 3);

                else if(x < 730 && y < 1130)
                    getIntent().putExtra("FObject", 4);

                else if(x < 1100 && y < 1130)
                    getIntent().putExtra("FObject", 5);

                else if(x < 365 && y < 1700)
                    getIntent().putExtra("FObject", 6);

                else if(x < 730 && y < 1700)
                    getIntent().putExtra("FObject", 7);

                else if(x < 1100 && y < 1700)
                    getIntent().putExtra("FObject", 8);

                Field_Info fragment1=new Field_Info();
               getFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment1).commit();




                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(i==0)
            super.onBackPressed();
        else if(i==1)
        {
            i=0;

            InitialLayout fragment2=new InitialLayout();
            getFragmentManager().beginTransaction().replace(R.id.frame_fragment, fragment2).commit();
        }

    }
}
