package com.example.mich.konwerter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KonwerterSignal extends MainActivity{

    Button buttonBack,konwert;
    EditText editText;
    TextView textView;
    private RelativeLayout relativelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konwerter_signal);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);
        konwert = (Button)findViewById(R.id.button);
        relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });

        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String[] elementy = {"ZAKRES TEMPERATURY:", " 0 ... 100°C", " 0 ... 150°C", " 0 ... 250°C", "-50... 150°C"," 0 ... 400°C"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, elementy);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                switch ((int) position) {
                    case 0:
                        String puste = editText.getText().toString();
                        if (puste.trim().equals("")) {
                            return;
                        }
                        break;
                    case 1:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = editText.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterSignal.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                float i = Float.parseFloat(String.valueOf(editText.getText()));
                                if (i >= 4 && i <= 20) {
                                    float x = (i - 4) * 200 / 16;
                                    textView.setText(x + "°C");
                                    //TODO zaokraglanie liczby do 2 miejsc po przecinku
                                }else
                                    {
                                        Toast.makeText(KonwerterSignal.this, "Podaj liczbę z zakresu 4-20 [mA]", Toast.LENGTH_SHORT).show();
                                    }
                            }
                        });
                        break;
                    case 2:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = editText.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterSignal.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                float i = Float.parseFloat(String.valueOf(editText.getText()));
                                if (i >= 4 && i <= 20) {
                                    float x = (i - 4) * 150 / 16;
                                    textView.setText(x + "°C");
                                }else
                                    {
                                    Toast.makeText(KonwerterSignal.this, "Podaj liczbę z zakresu 4-20 [mA]", Toast.LENGTH_SHORT).show();
                                    }
                            }
                        });
                        break;
                    case 3:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = editText.getText().toString();
                                if (puste.trim().equals("")) {
                                    Toast.makeText(KonwerterSignal.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                                float i = Float.parseFloat(String.valueOf(editText.getText()));
                                if (i >= 4 && i <= 20) {
                                    float x = (i - 4) * 250 / 16;
                                    textView.setText(x + "°C");
                                }else
                                {
                                    Toast.makeText(KonwerterSignal.this, "Podaj liczbę z zakresu 4-20 [mA]", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

                        break;
                    case 4:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = editText.getText().toString();
                                if(puste.trim().equals("")){
                                    Toast.makeText(KonwerterSignal.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                float i = Float.parseFloat(String.valueOf(editText.getText()));
                                if (i >= 4 && i <= 20) {
                                    float x = (i - 4) * 200 / 16 - 50;
                                    textView.setText(x + "°C");
                                }else
                                {
                                    Toast.makeText(KonwerterSignal.this, "Podaj liczbę z zakresu 4-20 [mA]", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        break;
                    case 5:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = editText.getText().toString();
                                if(puste.trim().equals("")){
                                    Toast.makeText(KonwerterSignal.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
                                    return;
                                }

                                float i = Float.parseFloat(String.valueOf(editText.getText()));
                                if(i>=4 && i<=20)
                                {
                                    float x = (i-4) * 400 / 16;
                                    textView.setText(x + "°C");
                                }else
                                {
                                    Toast.makeText(KonwerterSignal.this, "Podaj liczbę z zakresu 4-20 [mA]", Toast.LENGTH_SHORT).show();
                                }
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
                Intent intent = new Intent(KonwerterSignal.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}