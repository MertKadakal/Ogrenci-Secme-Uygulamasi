package mert.kadakal.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ogrenci_sec extends AppCompatActivity {

    Random random = new Random();
    private String snf;
    private TextView snfNo;
    private TextView secilen_ogr;
    private Button backtomain;
    private Button ogr_sec_buton;
    ArrayList<String> ogr_list = new ArrayList<>();

    private ArrayList<String> sinif1_ogr = new ArrayList<>(Arrays.asList("Öğrenci 1", "Öğrenci 2", "Öğrenci 3", "Öğrenci 4", "Öğrenci 5"));
    private ArrayList<String> sinif2_ogr = new ArrayList<>(Arrays.asList("Öğrenci 6", "Öğrenci 7", "Öğrenci 8", "Öğrenci 9", "Öğrenci 10"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ogrenci_sec);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backtomain = (Button) findViewById(R.id.backToMain);
        snfNo = (TextView) findViewById(R.id.Sınıf_no);
        secilen_ogr = (TextView) findViewById(R.id.secilen_ogr);
        Intent gelenIntent = getIntent();
        snf = gelenIntent.getStringExtra("Sınıf");
        snfNo.setText(snf);
        ogr_sec_buton = (Button) findViewById(R.id.ogr_sec_buton);

        ArrayList<ArrayList<String>> siniflar = new ArrayList<>();
        siniflar.add(sinif1_ogr);
        siniflar.add(sinif2_ogr);



        backtomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona basıldığında yapılacak işlemler buraya yazılır
                Intent intent = new Intent(ogrenci_sec.this, MainActivityJava.class);
                startActivity(intent);
            }
        });


        if (snf.equals("sinif1")) {
            ogr_list = siniflar.get(0);
        }
        else if (snf.equals("sinif2")) {
            ogr_list = siniflar.get(1);
        }
        ogr_sec_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Butona basıldığında yapılacak işlemler buraya yazılır
                if (ogr_list.size() > 0) {
                    int ind = random.nextInt(ogr_list.size());
                    secilen_ogr.setText(String.format("%s", ogr_list.get(ind)));
                    ogr_list.remove(ind);
                }
                else {
                    secilen_ogr.setText("Öğrenciler tamamlandı!");
                }
            }
        });
    }
}