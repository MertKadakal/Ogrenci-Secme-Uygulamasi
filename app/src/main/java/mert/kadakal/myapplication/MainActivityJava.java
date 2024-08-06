package mert.kadakal.myapplication;


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
    Random random = new Random();


    private Button sinif1;
    private Button sinif2;
    private Button sinif3;
    private Button sinif4;
    private Button backToMain;
    private Button ogr_sec;

    private TextView snfScnz;
    private TextView secili_ogr;

    private ArrayList<String> secili_snf;

    private ArrayList<String> sinif1_ogr = new ArrayList<>(Arrays.asList("Öğrenci 1", "Öğrenci 2", "Öğrenci 3", "Öğrenci 4", "Öğrenci 5"));

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sinif1 = (Button) findViewById(R.id.sinif1);
        sinif2 = (Button) findViewById(R.id.sinif2);
        sinif3 = (Button) findViewById(R.id.sinif3);
        sinif4 = (Button) findViewById(R.id.sinif4);
        backToMain = (Button) findViewById(R.id.backToMain);
        backToMain.setVisibility(View.INVISIBLE);
        ogr_sec = (Button) findViewById(R.id.ogr_sec);
        ogr_sec.setVisibility(View.INVISIBLE);
        mainPageVisibility(true, 0);

        snfScnz = (TextView) findViewById(R.id.sinifSeciniz);
        secili_ogr = (TextView) findViewById(R.id.secilen_ogr);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPageVisibility(false, v.getId());
            }
        };

        sinif1.setOnClickListener(listener);
        sinif2.setOnClickListener(listener);
        sinif3.setOnClickListener(listener);
        sinif4.setOnClickListener(listener);

        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklanınca yapılacak işlemler
                mainPageVisibility(true, 0);
            }
        });

        ogr_sec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona tıklanınca yapılacak işlemler
                if (secili_snf.size() > 0) {
                    int ind = random.nextInt(secili_snf.size());
                    secili_ogr.setText(secili_snf.get(ind));
                    secili_snf.remove(ind);
                }
                else {
                    secili_ogr.setText("Öğrenciler tamamlandı!");
                }
            }
        });
    }

    public void mainPageVisibility(boolean TF, int id) {
        if (!TF) {
            sinif1.setVisibility(View.INVISIBLE);
            sinif2.setVisibility(View.INVISIBLE);
            sinif3.setVisibility(View.INVISIBLE);
            sinif4.setVisibility(View.INVISIBLE);
            backToMain.setVisibility(View.VISIBLE);
            ogr_sec.setVisibility(View.VISIBLE);
            secili_ogr.setText("İlk öğrenciyi seçiniz");
            secili_ogr.setVisibility(View.VISIBLE);

            if (id == R.id.sinif1) {
                snfScnz.setText("Sınıf 1");
                secili_snf = new ArrayList<>(sinif1_ogr);
            }
            if (id == R.id.sinif2) {
                snfScnz.setText("Sınıf 2");
            }
            if (id == R.id.sinif3) {
                snfScnz.setText("Sınıf 3");
            }
            if (id == R.id.sinif4) {
                snfScnz.setText("Sınıf 4");
            }
        }
        else {
            sinif1.setVisibility(View.VISIBLE);
            sinif2.setVisibility(View.VISIBLE);
            sinif3.setVisibility(View.VISIBLE);
            sinif4.setVisibility(View.VISIBLE);
            backToMain.setVisibility(View.INVISIBLE);
            ogr_sec.setVisibility(View.INVISIBLE);
            secili_ogr.setVisibility(View.INVISIBLE);

            snfScnz.setText("Sınıf Seçiniz");
        }
    }
}
