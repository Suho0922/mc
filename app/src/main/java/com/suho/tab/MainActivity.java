package com.suho.tab;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.List;


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

        //FragMonday customListFrgmt = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);
        //ListViewAdapter LV = new ListViewAdapter();
        //customListFrgmt.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), "New Box", "New Account Box Black 36dp") ;
        }

    public void btn_Click1(View view){
        Intent InputPhoneNumber = new Intent(MainActivity.this,InputPhoneNumber.class);
        startActivity(InputPhoneNumber);
        //show();
    }
/*******
    void show()
    {
        final EditText edittext1 = new EditText(this);
        final EditText edittext2 = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("새로운 번호 추가");
        builder.setMessage("이름을 입력하시오.");
        builder.setMessage("전화번호를 입력하시오.");
        builder.setView(edittext1);
        builder.setView(edittext2);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        FragMonday customListFrgmt = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);
                        customListFrgmt.addItem(ContextCompat.getDrawable(getCallingActivity(), R.drawable.ic_account_test1), "New Box", "New Account Box Black 36dp") ;
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }
 ***************/
}
