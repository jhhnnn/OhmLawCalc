package com.example.e4jheino.gui_vko7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Intent volt = null;
    Intent cur = null;
    Intent res = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list);

        String[] val_arvot = new String[] {
                "Resistanssin laskeminen",
                "Jännitteen laskeminen",
                "Virran laskeminen",
                "Lopeta sovellus"
        };

        ArrayAdapter<String> oma_adapteri = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1, val_arvot);

        listView.setAdapter(oma_adapteri);
        volt = new Intent(MainActivity.this,calc_vol.class);
        cur = new Intent(MainActivity.this,calc_cur.class);
        res = new Intent(MainActivity.this,calc_res.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(res);
                }
                if(position == 1){
                    startActivity(volt);
                }
                if(position == 2){
                    startActivity(cur);
                }
                if(position == 3){
                    finish();
                }
            }
        });





    }


}
