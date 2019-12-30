package com.suho.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class InputPhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_phone_number);
    }

    public void btn_Click2(View view) {
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);

         FragmentManager NewInfo = getSupportFragmentManager();

         FragMonday tlqkf = (FragMonday) NewInfo.findFragmentById(R.id.fragmonday);
         if (tlqkf != null) {
            tlqkf.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), editText1.getText().toString(), editText2.getText().toString());
            Toast.makeText(getApplicationContext(), "입력완료", Toast.LENGTH_LONG).show();
        }
    }

    public void btn_Click3(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
