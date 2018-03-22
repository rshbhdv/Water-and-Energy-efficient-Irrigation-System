package com.example.tushar.iotbasedirrigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;


public class Field_Info extends android.app.Fragment {

    TextureView grid,pressure,temp,moisture,humidity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        Field_Object field_object= (Field_Object) getActivity().getIntent().getSerializableExtra("FObject");

        grid=(TextureView) view.findViewById(R.id.grid);

        temp=(TextureView) view.findViewById(R.id.temp);
        pressure=(TextureView) view.findViewById(R.id.pressure);
        moisture=(TextureView) view.findViewById(R.id.moisture);
        humidity=(TextureView) view.findViewById(R.id.humidity);


        return view;
    }

}
