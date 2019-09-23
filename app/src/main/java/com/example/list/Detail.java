package com.example.list;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    TextView name,deskripsi;
    ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        name = findViewById(R.id.txt_intent_nama_ilmuwan);
        deskripsi = findViewById(R.id.txt_deskripsi);
        foto = findViewById(R.id.img_ilmuwan);


        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("name");
        String receivedDeskripsi = intent.getStringExtra("deskripsi");
        int receivedFoto = intent.getIntExtra("foto",0);

        name.setText(receivedName);
        deskripsi.setText(receivedDeskripsi);
        foto.setImageResource(receivedFoto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(receivedName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
