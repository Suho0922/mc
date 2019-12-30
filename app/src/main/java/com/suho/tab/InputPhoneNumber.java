package com.suho.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

public class InputPhoneNumber extends AppCompatActivity {

    FragMonday Add;
    //String NAME = "NULL";
    //String PHONE_NUMBER = "NULL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_phone_number);
    }

    public void btn_Click2(View view) {
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        //NAME = editText1.getText().toString();
        //PHONE_NUMBER = editText2.getText().toString();
        Add.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), editText1.getText().toString(), editText2.getText().toString());

        /**********************************************
        FragMonday NewInfo = (FragMonday) getSupportFragmentManager().findFragmentById(R.id.fragmonday);

        if (NewInfo != null) {
            NewInfo.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_test1), editText1.getText().toString(), editText2.getText().toString());
        }
        **************************************************/
    }

    public void btn_Click3(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragMonday tlqkf = (FragMonday) fragmentManager.findFragmentById(R.id.fragmonday);

     //ddfasjiejf;aisejf;ilsjfiisfejl
    //21323123
}
