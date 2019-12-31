package com.suho.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class InputPhoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_phone_number);
    }

    public void btn_Click2(View view) {
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        FragmentTransaction NewInfo = getSupportFragmentManager().beginTransaction();

        /*********
        FragMonday InputNew = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);
        if (InputNew != null) {
            InputNew.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), editText1.getText().toString(), editText2.getText().toString());
            Toast.makeText(getApplicationContext(), "입력완료", Toast.LENGTH_LONG).show();
        }
        **********/

        FragMonday fragment = new FragMonday();

        Bundle bundle = new Bundle();
        bundle.putString("NAME",editText1.getText().toString());
        bundle.putString("PHONE_NUMBER",editText2.getText().toString());
        fragment.setArguments(bundle);

        //FragMonday tf = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday22);
        //tf.refresh();
    }

    public void btn_Click3(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
