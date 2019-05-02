package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class HotelDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_detalhe_activity);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            Hotel produto = (Hotel) intent.getSerializableExtra("produto");
            HotelDetalheFragment fragment = HotelDetalheFragment.instanciaFragment(produto);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalheLayout, fragment, HotelDetalheFragment.TAG_DETALHE);
            ft.commit();
        }
    }
}
