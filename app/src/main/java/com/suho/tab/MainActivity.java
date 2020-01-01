package com.suho.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;



public class MainActivity extends AppCompatActivity {

    private viewPagerAdapter fragmentPagerAdapter;

    public static final int REQUEST_CODE_INSERT = 1818;

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

        //FragMonday addFragment = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);
        //addFrgment.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), "New Box", "New Account Box Black 36dp") ;
        //fragmentPagerAdapter.
        }

    public void btn_Click1(View view){
        Intent InputPhoneNumber = new Intent(MainActivity.this,InputPhoneNumber.class);
        startActivityForResult(InputPhoneNumber, REQUEST_CODE_INSERT);
        //show();
    }
/**********
    public void refresh(){
        fragmentPagerAdapter.notifyDataSetChanged();
    }
 **********/

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
