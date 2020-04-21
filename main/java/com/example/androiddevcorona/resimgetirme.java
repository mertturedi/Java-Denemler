package com.example.androiddevcorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class resimgetirme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resimgetirme);


        new DownloadImageTask((ImageView) findViewById(R.id.Image))
                .execute("https://coronavirus-monitor.p.rapidapi.com/coronavirus/random_masks_usage_instructions.php?rapidapi-key=ec3e6b47e8msha98c1e1e0da5d31p18bc85jsncfbb22e6808e");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(resimgetirme.this,MainActivity.class);
                startActivity(intent);
            }
        }, 10000);


    }
}
