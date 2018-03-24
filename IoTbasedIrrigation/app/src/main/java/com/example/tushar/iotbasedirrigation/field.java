package com.example.tushar.iotbasedirrigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


        RequestQueue requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, "http://192.168.43.11:1337/field/layout",null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // textView.setText("Entered");

                            JSONObject ob = response.getJSONObject(0);

                            JSONArray jsonArray = ob.getJSONArray("result");


                                JSONObject crop =jsonArray.getJSONObject(0);
                                object.grid=crop.getString("grid");
                                object.temp=crop.getString("temp");
                                object.pressure=crop.getString("pressure");
                                object.moisture=crop.getString("moisture");
                                object.humidity=crop.getString("humidity");

                                Log.d("Grid",object.grid);




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("error");
                Log.e("Length","Error");
            }
        });

        requestQueue.add(jsonObjectRequest);

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

                if(y<900)
                {
                    Toast.makeText(getApplicationContext(),"Upper half",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Lower half",Toast.LENGTH_LONG).show();
                }

                getIntent().putExtra("FObject", object);

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
