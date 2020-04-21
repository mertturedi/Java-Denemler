package com.example.androiddevcorona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements CoronaReq.CoronaReqListener {


    TextView totalCases;
    TextView totalDeaths;
    TextView totalRecovered;
    TextView statisticTakenAt;
    TextView newCases;
    TextView newDeaths;


Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalCases=findViewById(R.id.totalCases);
        totalDeaths=findViewById(R.id.totalDeaths);
        totalRecovered=findViewById(R.id.totalRecovered);
        statisticTakenAt=findViewById(R.id.statisticTakenAt);
        newCases=findViewById(R.id.newCases);
        newDeaths=findViewById(R.id.newDeaths);

        CoronaReq req=new CoronaReq(this);
        req.execute();

        btn=findViewById(R.id.gecis);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gecisYap = new Intent(MainActivity.this, sayfaiki.class);
                startActivity(gecisYap);
            }
        });





    }

    @Override
    public void coronaReqDone(String result) {
        Gson gson = new Gson();
        CoronaModel model = gson.fromJson(result, CoronaModel.class);
        totalCases.setText(model.total_cases);
        totalDeaths.setText(model.total_deaths);
        totalRecovered.setText(model.total_recovered);
        newCases.setText(model.new_cases);
        newDeaths.setText(model.new_deaths);
        statisticTakenAt.setText(model.statistic_taken_at);
    }
}
