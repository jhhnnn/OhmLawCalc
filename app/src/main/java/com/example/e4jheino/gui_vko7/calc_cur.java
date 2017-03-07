package com.example.e4jheino.gui_vko7;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_cur extends AppCompatActivity {
    private Button laske;
    private EditText res, vol;
    private TextView vastaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_cur);

        final InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        laske = (Button) findViewById(R.id.button2);
        res = (EditText) findViewById(R.id.edit_resis);
        vol = (EditText) findViewById(R.id.edit_vol);
        vastaus = (TextView) findViewById(R.id.vir_vastaus);

        vastaus.setText("Jännite / Resistanssi = Virta");

        laske.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String temp1 = res.getText().toString();
                String temp2 = vol.getText().toString();

                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                double resistanssi = 0, voltti = 0;

                try {
                    resistanssi = Double.parseDouble(temp1);
                    voltti = Double.parseDouble(temp2);
                }catch (NumberFormatException e){
                    vastaus.setText("Error!");
                }
                if(resistanssi!=0) {
                    vastaus.setText(voltti / resistanssi + " Amps");
                }else{
                    vastaus.setText("Ei voi jakaa 0:lla");
                }
            }
        });


    }

}
