package com.example.user.praktikum7;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements AmbilGambar.Listener{
EditText et_link;
Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_link = (EditText) findViewById(R.id.et_link);
        btn_ok = (Button) findViewById(R.id.btn);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OPEN DETAIL ACTIVITY
                String url = et_link.getText().toString();
               new AmbilGambar(MainActivity.this).execute(url);
            }
        });

    }

    @Override
    public void onLoadImage(Bitmap bitmap) {
        ImageView iv=(ImageView)findViewById(R.id.logo);
        iv.setImageBitmap(bitmap);
    }
}
