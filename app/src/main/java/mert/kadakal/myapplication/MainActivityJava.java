package mert.kadakal.myapplication;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityJava extends AppCompatActivity {

    private TextView txtMessage;
    private Button btnMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMessage = (TextView) findViewById(R.id.mertkadakal_yazisi);
        btnMessage = (Button) findViewById(R.id.buton1);
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_Q) {
            // "q" tuşuna basıldığında çalışacak kod
            txtMessage.setVisibility(View.INVISIBLE);
            btnMessage.setText("buton2");
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
