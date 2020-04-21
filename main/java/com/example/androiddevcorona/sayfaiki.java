package com.example.androiddevcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class sayfaiki extends AppCompatActivity implements coronaReq2.coronaReq2listener {

    ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfaiki);

        listView1=findViewById(R.id.listview1);
        coronaReq2 req2=new coronaReq2(this);
        req2.execute();









    }

    @Override
    public void coronaReqdone(String result) {
        Gson gson = new Gson();
        CoronaModel2 veriler = gson.fromJson(result,CoronaModel2.class);

        List<String> values = new ArrayList<>();

        for (int i = 0; i<veriler.affected_countries.length;i++){
            values.add(veriler.affected_countries[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.listitem,R.id.view,values);
        listView1.setAdapter(arrayAdapter);


        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent gecisYap = new Intent(sayfaiki.this, sayfauc.class);
                startActivity(gecisYap);
            }
        });









    }
}
