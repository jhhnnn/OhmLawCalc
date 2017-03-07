package com.example.e4jheino.gui_vko7;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calc_res extends AppCompatActivity {
    private Button laske;
    private EditText vol,vir;
    private TextView vastaus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_res);

        final InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        laske = (Button) findViewById(R.id.button);
        vir = (EditText) findViewById(R.id.edit_virta);
        vol = (EditText) findViewById(R.id.edit_jännite);
        vastaus = (TextView) findViewById(R.id.res_vastaus);

        vastaus.setText("Jännite / Virta = Resistanssi");

        laske.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String temp1 = vir.getText().toString();
                String temp2 = vol.getText().toString();

                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                    double virta = 0, voltti = 0;
                try {
                    virta = Double.parseDouble(temp1);
                    voltti = Double.parseDouble(temp2);
                }catch(NumberFormatException e){
                    vastaus.setText("Error!");
                }
                if(virta!=0) {
                    vastaus.setText(voltti / virta + " Ohm");
                }else{
                    vastaus.setText("Ei voi jakaa 0:lla");
                }
            }
        });


    }
}
