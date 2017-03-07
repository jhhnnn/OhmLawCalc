package com.example.e4jheino.gui_vko7;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_vol extends AppCompatActivity {
    private Button laske;
    private EditText res,vir;
    private TextView vastaus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_vol);

        final InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        laske = (Button) findViewById(R.id.button3);
        res = (EditText) findViewById(R.id.edit_resis);
        vir = (EditText) findViewById(R.id.edit_vir);
        vastaus = (TextView) findViewById(R.id.jän_vast);

        vastaus.setText("Resistanssi * Virta = Jännite");


        laske.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String temp1 = res.getText().toString();
                String temp2 = vir.getText().toString();

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                double resistanssi = 0, virta = 0;

                try {
                    resistanssi = Double.parseDouble(temp1);
                    virta = Double.parseDouble(temp2);
                }catch (NumberFormatException e){
                    vastaus.setText("Error!");
                }

                vastaus.setText(resistanssi*virta+" Volttia");
            }
        });

    }




}
