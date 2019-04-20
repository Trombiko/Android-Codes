package com.example.mich.konwerter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KonwerterDlugosci extends MainActivity {
    Button konwert;
    Button buttonBack;
    EditText liczba;
    TextView text, text1,text2;
    ImageView counting;
    private RelativeLayout relativelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.konwerter_dlugosci);

        liczba = (EditText) findViewById(R.id.editText);
        text = (TextView) findViewById(R.id.textView);
        text1 = (TextView) findViewById(R.id.textView1);
        text2 = (TextView) findViewById(R.id.textView2);
        konwert = (Button) findViewById(R.id.button1);
        counting = (ImageView) findViewById(R.id.imageView); counting.setVisibility(View.INVISIBLE);
        relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        relativelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
            }
        });

        final Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        String[] elementy = {"JEDNOSTKI DŁUGOŚCI:", "milimetry   (mm)", "centymetry (cm)", "metry         (m)", "kilometry   (km)"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elementy);
        spinner.setAdapter(adapter);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {


                switch ((int) position) {
                    case 0:
                        konwert.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String puste = liczba.getText().toString();
                                if (puste.trim().equals("")) {
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
                                    Toast.makeText(KonwerterDlugosci.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(KonwerterDlugosci.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(KonwerterDlugosci.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(KonwerterDlugosci.this, "BRAK LICZBY DO PRZEKONWERTOWANIA ", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(KonwerterDlugosci.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
