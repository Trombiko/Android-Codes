package com.example.mich.konwerter;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class KonwerterSignal extends MainActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konwerter_signal);


        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] elementy = {"", "0...100°C", "0...150°C", "0-250°C", "-50...150°C","0...400°C"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elementy);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {


                switch((int)position)
                {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}
