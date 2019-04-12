package com.example.mich.konwerter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KonwerterMasa extends MainActivity {
    Button konwert;
    Button buttonBack;
    EditText liczba;
    TextView text, text1,text2;
    ImageView counting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konwerter_masa);

        liczba = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        konwert = (Button) findViewById(R.id.button1);
        counting = (ImageView) findViewById(R.id.imageView); counting.setVisibility(View.INVISIBLE);


        final Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String[] elementy = {"", "milimetry", "centymetry", "metry", "kilometry"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementy);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {

                //Toast.makeText(KonwerterMasa.this, "Wybrano opcję" + (id + 1), Toast.LENGTH_SHORT).show();

                switch ((int) position) {
                    case 0:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterMasa.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
                        break;
                    case 1:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterMasa.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                counting.setVisibility(View.VISIBLE);
                                float i = Float.parseFloat(String.valueOf(liczba.getText()));
                                double cm = i * 0.1, m = i * 0.001, km = i * 0.000001;
                                try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
                                text.setText(cm + " centymetrow");
                                text1.setText(m + " metrow");
                                text2.setText(km + "kilometrow");
                            }
                        });
                        break;
                    case 2:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterMasa.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                counting.setVisibility(View.VISIBLE);
                                float i = Float.parseFloat(String.valueOf(liczba.getText()));
                                double mm = i * 100, m = i * 0.01, km = i * 0.00001;
                                try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
                                text.setText(mm + " milimetrow");
                                text1.setText(m + " metrow");
                                text2.setText(km + " kilometrow");
                            }
                        });
                        break;
                    case 3:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterMasa.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                counting.setVisibility(View.VISIBLE);
                                float i = Float.parseFloat(String.valueOf(liczba.getText()));
                                double mm = i * 1000, cm = i * 100, km = i * 0.001;
                                try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
                                text.setText(mm + " milimetrow");
                                text1.setText(cm + " centymetrow");
                                text2.setText(km + " kilometrow");
                            }
                        });
                        break;
                    case 4:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterMasa.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                counting.setVisibility(View.VISIBLE);
                                float i = Float.parseFloat(String.valueOf(liczba.getText()));
                                double mm = i * 1000000, cm = i * 10000, m = i * 1000;
                                try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
                                text.setText(mm + " milimetrow");
                                text1.setText(cm + " centymetrow");
                                text2.setText(m + " metrow");
                            }
                        });
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KonwerterMasa.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
