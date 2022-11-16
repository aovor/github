package com.example.p264_6_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabDog = tabHost.newTabSpec("DOG").setIndicator("강아지");
        tabDog.setContent(R.id.dog);
        tabHost.addTab(tabDog);

        TabHost.TabSpec tabCat = tabHost.newTabSpec("CAT").setIndicator("고양이");
        tabCat.setContent(R.id.cat);
        tabHost.addTab(tabCat);

        TabHost.TabSpec tabRabbit = tabHost.newTabSpec("RABBIT").setIndicator("토끼");
        tabRabbit.setContent(R.id.rabbit);
        tabHost.addTab(tabRabbit);

        TabHost.TabSpec tabHorse = tabHost.newTabSpec("HORSE").setIndicator("말");
        tabHorse.setContent(R.id.horse);
        tabHost.addTab(tabHorse);

        tabHost.setCurrentTab(0);
    }
}