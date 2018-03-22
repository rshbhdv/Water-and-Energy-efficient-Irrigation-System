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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.field_layout);

        RequestQueue requestQueue= Volley.newRequestQueue(this);

        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, "http://192.168.43.11:1337/field/layout",null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // textView.setText("Entered");

                            JSONObject ob = response.getJSONObject(0);

                            JSONArray jsonArray = ob.getJSONArray("result");

                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject crop =jsonArray.getJSONObject(i);
                                String grid=crop.getString("grid");
                                String temp=crop.getString("temp");
                                String pressure=crop.getString("pressure");
                                String moisture=crop.getString("moisture");
                                String humidity=crop.getString("humidity");

                                Log.d("Grid",grid);

                            }


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
