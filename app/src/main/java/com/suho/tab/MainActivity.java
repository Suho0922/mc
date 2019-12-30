package com.suho.tab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view pager setting
        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
        //어댑터 생성

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        /*********
        FragMonday customListFrgmt = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);
        customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), "New Box", "New Account Box Black 36dp") ;
         **********/
        }


    public void btn_Click1(View view){
        Intent InputPhoneNumberIntent = new Intent(MainActivity.this,InputPhoneNumber.class);
        startActivity(InputPhoneNumberIntent);
    }
}
