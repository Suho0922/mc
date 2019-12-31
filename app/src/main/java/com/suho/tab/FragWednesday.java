package com.suho.tab;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class FragWednesday extends Fragment {

    private Context context;
    static int Money = 2000;

    public static FragWednesday newinstance(){
        FragWednesday fragWednesday = new FragWednesday();
        return fragWednesday;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_wednesday, container, false);
        context = container.getContext();
        TextView textView;


        Button button3 = (Button) view.findViewById(R.id.button3);
        final TextView textView3 = (TextView)view.findViewById(R.id.textView3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Money <= 0){
                    Toast.makeText(context, "거지십니다", Toast.LENGTH_SHORT).show();
                } else  {
                    double random = Math.random() * 10d;
                    if (random < 1d) {
                        textView3.setText("너무 안좋습니다. 그만두십시오.");
                    } else if (random < 3d) {
                        textView3.setText("그저 그렇습니다. 굳이...?");
                    } else if (random < 7d) {
                        textView3.setText("평범합니다.");
                    } else if (random < 9d) {
                        textView3.setText("운이 조금 보이는군요");
                    } else
                        textView3.setText("대박입니다. 빨리 경마하러가세요");
                    Money -= 200;
                }
            }
        });


        //FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.detach(this).attach(this).commit();

        textView = (TextView)view.findViewById(R.id.MoneyTextView);
        textView.setText("현재 가지고 있는 돈 : " + Money);



        Button buttonA = (Button) view.findViewById(R.id.buttonA);
        Button buttonB = (Button) view.findViewById(R.id.buttonB);
        Button buttonC = (Button) view.findViewById(R.id.buttonC);
        Button buttonD = (Button) view.findViewById(R.id.buttonD);
        Button buttonE = (Button) view.findViewById(R.id.buttonE);

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney = Integer.parseInt(betbet);

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 1);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    getActivity().startActivity(intentA);  // 발송
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney = Integer.parseInt(betbet);

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_LONG).show();

                    //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 2);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    getActivity().startActivity(intentA);  // 발송
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney = Integer.parseInt(betbet);

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_LONG).show();

                    //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 3);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    getActivity().startActivity(intentA);  // 발송
                }
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney = Integer.parseInt(betbet);

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_LONG).show();

                    //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 4);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    getActivity().startActivity(intentA);  // 발송
                }
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney = Integer.parseInt(betbet);

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_LONG).show();

                    //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 5);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    getActivity().startActivity(intentA);  // 발송
                }
            }
        });


        return view;
    }
}
