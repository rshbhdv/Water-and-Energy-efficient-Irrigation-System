package com.example.tushar.iotbasedirrigation;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Field_Info extends android.app.Fragment {

    TextView grid,pressure,temp,moisture,humidity;
    Field_Object field_object;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.field_info_fragment, container, false);

       final int n=(int) getActivity().getIntent().getSerializableExtra("FObject");

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        field_object=new Field_Object();

        JsonArrayRequest jsonObjectRequest=new JsonArrayRequest(Request.Method.GET, "http://192.168.43.11:1337/field/layout",null,
                new Response.Listener<JSONArray>() {
                    @SuppressLint("ResourceAsColor")
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            // textView.setText("Entered");

                            JSONObject ob = response.getJSONObject(0);

                            JSONArray jsonArray = ob.getJSONArray("result");

                            JSONObject crop =jsonArray.getJSONObject(n);
                            field_object.grid=crop.getString("grid");
                            field_object.temp=crop.getString("temp");
                            field_object.pressure=crop.getString("pressure");
                            field_object.moisture=crop.getString("moisture");
                            field_object.humidity=crop.getString("humidity");

                            Log.d("Grid",field_object.grid);

                            grid=(TextView) getView().findViewById(R.id.grid);
                            grid.setText(field_object.grid);

                            temp=(TextView) getView().findViewById(R.id.temp);
                            temp.setText(field_object.temp);

                            pressure=(TextView) getView().findViewById(R.id.pressure);
                            pressure.setText(field_object.pressure);

                            moisture=(TextView) getView().findViewById(R.id.moisture);
                            moisture.setText(field_object.moisture);

                            humidity=(TextView) getView().findViewById(R.id.humidity);
                            humidity.setText(field_object.humidity);


                            if(Integer.valueOf(field_object.moisture) > -15)
                            {
                                moisture.setBackgroundColor(Color.BLUE);
                            }


                            else if(Integer.valueOf(field_object.moisture) > -20)
                            {
                                moisture.setBackgroundColor(Color.GREEN);
                            }


                            else if(Integer.valueOf(field_object.moisture) > -50)
                            {
                                moisture.setBackgroundColor(Color.MAGENTA);
                            }

                            else if(Integer.valueOf(field_object.moisture) > -100)
                            {
                                moisture.setBackgroundColor(Color.RED);
                            }

                            else if(Integer.valueOf(field_object.moisture) <= -100)
                            {
                                moisture.setBackgroundColor(Color.GRAY);
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


//        Log.d("Grid1",field_object.grid);

        return view;
    }
}


