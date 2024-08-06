package mert.kadakal.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivityJava extends AppCompatActivity {

    private Button sinif1;
    private Button sinif2;
    private Button sinif3;
    private Button sinif4;

    private TextView snfScnz;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sinif1 = (Button) findViewById(R.id.sinif1);
        sinif2 = (Button) findViewById(R.id.sinif2);
        sinif3 = (Button) findViewById(R.id.sinif3);
        sinif4 = (Button) findViewById(R.id.sinif4);

        snfScnz = (TextView) findViewById(R.id.sinifSeciniz);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityJava.this, ogrenci_sec.class);
                intent.putExtra("Sınıf", getResources().getResourceEntryName(v.getId()));
                startActivity(intent);
            }
        };

        sinif1.setOnClickListener(listener);
        sinif2.setOnClickListener(listener);
        sinif3.setOnClickListener(listener);
        sinif4.setOnClickListener(listener);
    }
}