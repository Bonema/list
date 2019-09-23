package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;
    private int tmp;
    int[] foto = new int[1000];
       //private String[] dataName = {"Abu Bakar Muhammad bin Zakaria ar-Razy","Abu Ali Muhammad al-Hassan","Abu Yusuf Yacub Ibnu Ishak Al-Kindi","Abul Qasim Khalaf ibn al-Abbas az-Zahrawi","Ibnu Rushd","Abu Raihan Al-Biruni","Muhammad Ibnu Musa Al-Khawarizmi","Abu Nasir Al-Farabi","Abul Wafa Muhammad","Abu Ali Al-Husein Ibnu Shina","Piri Reis","Omar Al-Khayyám"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new HeroAdapter(this);

        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Detail.class);
                intent.putExtra("name",dataName[i]);
                intent.putExtra("deskripsi",dataDescription[i]);
                intent.putExtra("foto",foto[i]);
                //intent.putExtra("foto",dataPhoto.getResourceId(i));
                startActivity(intent);
            }
        });

        prepare();
        addItem();

        }

        private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        }

        private void addItem() {
        heroes = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Hero hero = new Hero();
            tmp = dataPhoto.getResourceId(i,-1);
            hero.setPhoto(tmp);
            foto[i] = tmp;
            //hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            heroes.add(hero);
            }

        adapter.setHeroes(heroes);
        }
}