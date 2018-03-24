package com.example.tushar.iotbasedirrigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Field_Info extends android.app.Fragment {

    TextView grid,pressure,temp,moisture,humidity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.field_info_fragment, container, false);
        Field_Object field_object= (Field_Object) getActivity().getIntent().getSerializableExtra("FObject");

        grid=(TextView) view.findViewById(R.id.grid);
        grid.setText(field_object.grid);

        temp=(TextView) view.findViewById(R.id.temp);
        temp.setText(field_object.temp);

        pressure=(TextView) view.findViewById(R.id.pressure);
        pressure.setText(field_object.pressure);

        moisture=(TextView) view.findViewById(R.id.moisture);
        moisture.setText(field_object.moisture);

        humidity=(TextView) view.findViewById(R.id.humidity);
        humidity.setText(field_object.humidity);

        return view;
    }
}


