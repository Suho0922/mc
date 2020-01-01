package com.suho.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class GungMa extends AppCompatActivity {

    static int MoneyR;

    ImageView horse1;
    ImageView horse2;
    ImageView horse3;
    ImageView horse4;
    ImageView horse5;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gungma);

        Intent intent = getIntent(); // 값을 받자
        int ChosenHorse = intent.getIntExtra("horse", 0); //고른말
        int Money = intent.getIntExtra("money", 0);  // 현재금액
        int BET = intent.getIntExtra("bet", 0);  //배팅금액


        // 이기는 말
        final int WinnerHorse;
        double random = Math.random() * 100d;
        if (random > 58d) {
            WinnerHorse = 1;
        } else if (random > 28d) {
            WinnerHorse = 2;
        } else if (random > 10d) {
            WinnerHorse = 3;
        } else if (random > 3d) {
            WinnerHorse = 4;
        } else
            WinnerHorse = 5;

        if (WinnerHorse == ChosenHorse){
            if(WinnerHorse == 1){
                Money = Money + 2*BET;
            } else if(WinnerHorse ==2){
                Money = Money + 3*BET;
            } else if(WinnerHorse ==3){
                Money = Money + 5*BET;
            } else if(WinnerHorse ==4){
                Money = Money + 13*BET;
            } else {
                Money = Money + 30*BET;
            }
        }
        else {
            Money = Money - BET;
        }


        horse1 = (ImageView) findViewById(R.id.aaa);
        horse2 = (ImageView) findViewById(R.id.bbb);
        horse3 = (ImageView) findViewById(R.id.ccc);
        horse4 = (ImageView) findViewById(R.id.ddd);
        horse5 = (ImageView) findViewById(R.id.eee);

        final Animation horse1move = AnimationUtils.loadAnimation(this,R.anim.horse_move1);
        final Animation horse2move = AnimationUtils.loadAnimation(this,R.anim.horse_move2);
        final Animation horse3move = AnimationUtils.loadAnimation(this,R.anim.horse_move3);
        final Animation horse4move = AnimationUtils.loadAnimation(this,R.anim.horse_move4);
        final Animation horse5move = AnimationUtils.loadAnimation(this,R.anim.horse_move5);


        //애니메이션

        Button btnRight = (Button) findViewById(R.id.btn_right);

                switch (WinnerHorse) {
                    case 1:
                        btnRight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                horse1.startAnimation((horse1move));
                                horse2.startAnimation((horse2move));
                                horse3.startAnimation((horse3move));
                                horse4.startAnimation((horse4move));
                                horse5.startAnimation((horse5move));
                            }
                        });
                        break;

                    case 2:
                        btnRight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                horse1.startAnimation((horse2move));
                                horse2.startAnimation((horse1move));
                                horse3.startAnimation((horse3move));
                                horse4.startAnimation((horse4move));
                                horse5.startAnimation((horse5move));
                            }
                        });
                        break;

                    case 3:
                        btnRight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                horse1.startAnimation((horse3move));
                                horse2.startAnimation((horse2move));
                                horse3.startAnimation((horse1move));
                                horse4.startAnimation((horse5move));
                                horse5.startAnimation((horse4move));
                            }
                        });
                        break;

                    case 4:
                        btnRight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                horse4.startAnimation((horse1move));
                                horse2.startAnimation((horse2move));
                                horse3.startAnimation((horse3move));
                                horse1.startAnimation((horse4move));
                                horse5.startAnimation((horse5move));
                            }
                        });
                        break;

                    case 5:
                        btnRight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                horse5.startAnimation((horse1move));
                                horse2.startAnimation((horse2move));
                                horse1.startAnimation((horse3move));
                                horse4.startAnimation((horse4move));
                                horse3.startAnimation((horse5move));
                            }
                        });
                        break;

                    default:
                        break;
                }

        //결과값 전송
        MoneyR = Money;
        Button turn_back_button = (Button) findViewById(R.id.tung_back_button);

        turn_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMoney = new Intent();
                intentMoney.putExtra("MoneyI", MoneyR);
                intentMoney.putExtra("HorseI", WinnerHorse);
                setResult(RESULT_OK, intentMoney);
                finish();
            }
        });

    }
}
