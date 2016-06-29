package com.bignerdranch.android.nerdmail.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bignerdranch.android.nerdmail.R;

public class DrawerActivity extends AppCompatActivity {
    private static final String TAG = "DrawerActivity";
    private static final String EXTRA_CURRENT_DRAWER_ITEM
            = "DrawerActivity.CurrentDrawerItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
