package com.suho.tab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;



public class FragWednesday extends Fragment {

    private Context context;
    static int Money = 2000;
    public static final int REQUEST_CODE_GUNGMA = 101;
    public static final int REQUEST_CODE_WUNSE = 1004;

    public static FragWednesday newinstance(){
        FragWednesday fragWednesday = new FragWednesday();
        return fragWednesday;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //경마하고 오면
        if(requestCode == REQUEST_CODE_GUNGMA){
            int money = data.getExtras().getInt("MoneyI");
            int horse = data.getExtras().getInt("HorseI");
            String Cheer;
            String Win;

            if (money > Money){
                Cheer = "이겼습니다!!!";
            } else {
                Cheer = "돈을 잃으셨습니다";
            }

            switch (horse){
                case 1 :
                    Win = "역시 적토마군요!";
                    break;
                case 2 :
                    Win = "백마 참 좋은 말이죠";
                    break;
                case 3 :
                    Win = "조랑말이 힘을 냈군요!";
                    break;
                case 4 :
                    Win = "역시 신토불이 제주도 당나귀입니다!";
                    break;
                default:
                    Win = "승부조작을 의심해봐야겠군요";
            }
            Toast.makeText(getActivity(),Cheer + "\n" + Win + "\n 현재 소지금액은 "+ money, Toast.LENGTH_SHORT).show();

            Money = money;

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
        }

        // 운세보고 오면
        if(requestCode == REQUEST_CODE_WUNSE){
            int money = data.getExtras().getInt("BOKCHAE");

            Toast.makeText(getActivity(),"복채 감사합니다 :)", Toast.LENGTH_SHORT).show();

            Money = money;

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.frag_wednesday, container, false);
        context = container.getContext();
        TextView textView;

        Button button3 = (Button) view.findViewById(R.id.button3);
        //final TextView textView3 = (TextView)view.findViewById(R.id.textView3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Money <= 0){
                    Toast.makeText(context, "거지십니다", Toast.LENGTH_SHORT).show();
                } else  {
                    double random = Math.random() * 10d;
                    if (random < 1d) {
                        Intent intent = new Intent(getActivity(), Lucky.class);        // 인텐트 준비
                        intent.putExtra("LUCKY", 1);                    // 운세발송
                        intent.putExtra("BOKCHAE", Money);
                        startActivityForResult(intent, REQUEST_CODE_WUNSE);

                    } else if (random < 3d) {
                        Intent intent = new Intent(getActivity(), Lucky.class);
                        intent.putExtra("LUCKY", 2);
                        intent.putExtra("BOKCHAE", Money);
                        startActivityForResult(intent, REQUEST_CODE_WUNSE);

                    } else if (random < 7d) {
                        Intent intent = new Intent(getActivity(), Lucky.class);
                        intent.putExtra("LUCKY", 3);
                        intent.putExtra("BOKCHAE", Money);
                        startActivityForResult(intent, REQUEST_CODE_WUNSE);

                    } else if (random < 9d) {
                        Intent intent = new Intent(getActivity(), Lucky.class);
                        intent.putExtra("LUCKY", 4);
                        intent.putExtra("BOKCHAE", Money);
                        startActivityForResult(intent, REQUEST_CODE_WUNSE);

                    } else {
                        Intent intent = new Intent(getActivity(), Lucky.class);
                        intent.putExtra("LUCKY", 5);
                        intent.putExtra("BOKCHAE", Money);
                        startActivityForResult(intent, REQUEST_CODE_WUNSE);
                    }
                }
                //((MainActivity)getActivity()).refresh();   refresh try3
                //FragmentTransaction ft = getFragmentManager().beginTransaction();   refresh try2
                //ft.detach(FragWednesday.newinstance()).attach(FragWednesday.newinstance()).commit();   refresh try3
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
                int betmoney;
                if (betbet.length() != 0) {
                    betmoney = Integer.parseInt(betbet);
                } else {
                    betmoney = 0;
                }

                //베팅 못할 시
                if (editText.getText().toString().length() == 0 || Money < betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 1);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    startActivityForResult(intentA, REQUEST_CODE_GUNGMA);  // 발송
                }
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney;
                if (betbet.length() != 0) {
                    betmoney = Integer.parseInt(betbet);
                } else {
                    betmoney = 0;
                }

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 2);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    startActivityForResult(intentA, REQUEST_CODE_GUNGMA);  // 발송
                }
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney;
                if (betbet.length() != 0) {
                    betmoney = Integer.parseInt(betbet);
                } else {
                    betmoney = 0;
                }

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 3);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    startActivityForResult(intentA, REQUEST_CODE_GUNGMA);  // 발송
                }
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney;
                if (betbet.length() != 0) {
                    betmoney = Integer.parseInt(betbet);
                } else {
                    betmoney = 0;
                }

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 4);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    startActivityForResult(intentA, REQUEST_CODE_GUNGMA);  // 발송
                }
            }
        });

        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText)view.findViewById(R.id.BetEditText);  //베팅금액 받기

                //베팅금액 변환
                String betbet = editText.getText().toString();
                int betmoney;
                if (betbet.length() != 0) {
                    betmoney = Integer.parseInt(betbet);
                } else {
                    betmoney = 0;
                }

                //베팅 못할 시
                if (betbet.length() == 0 || Money <= betmoney) {
                    Toast.makeText(context, "베팅할 수 없습니다", Toast.LENGTH_SHORT).show();

                //베팅 시작하면 GungMa 로 intent 전환
                } else {
                    Intent intentA = new Intent(getActivity(), GungMa.class);  // 인텐트 준비
                    intentA.putExtra("money", Money);  // 가지고 있는 돈 발송준비
                    intentA.putExtra("horse", 5);  // 고른말 발송준비
                    intentA.putExtra("bet", betmoney);  // 베팅금액 발송준비
                    startActivityForResult(intentA, REQUEST_CODE_GUNGMA);  // 발송
                }
            }
        });

        return view;
    }
}
