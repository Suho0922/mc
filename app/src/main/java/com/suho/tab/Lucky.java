package com.suho.tab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Lucky extends AppCompatActivity {

    ImageView BB, B, soso, G, GG;
    TextView chi, hap, dae, gwang;
    static int MoneyC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lucky);

        Intent intent = getIntent(); // 값을 받자
        int LUCKY = intent.getIntExtra("LUCKY", 0); //  운세
        int BOKCHAE = intent.getIntExtra("BOKCHAE", 0);  //복채

        //부적
        final Animation chose1 = AnimationUtils.loadAnimation(this, R.anim.move_rr);
        final Animation chose2 = AnimationUtils.loadAnimation(this, R.anim.move_r);
        final Animation chose3 = AnimationUtils.loadAnimation(this, R.anim.move_l);
        final Animation chose4 = AnimationUtils.loadAnimation(this, R.anim.move_ll);
        final Animation remove = AnimationUtils.loadAnimation(this,R.anim.remove);
        BB = (ImageView) findViewById(R.id.imageViewbb);
        B = (ImageView) findViewById(R.id.imageViewb);
        soso = (ImageView) findViewById(R.id.imageViewsoso);
        G = (ImageView) findViewById(R.id.imageViewg);
        GG = (ImageView) findViewById(R.id.imageViewg);
        //

        //도움말
        chi = (TextView) findViewById(R.id.chighik);
        hap = (TextView) findViewById(R.id.hap);
        dae = (TextView) findViewById(R.id.dae);
        gwang = (TextView) findViewById(R.id.gwang);

        final Animation bujuk = AnimationUtils.loadAnimation(this,R.anim.bujuk);


        switch (LUCKY) {
            case 1:
                BB.startAnimation((chose1));
                B.startAnimation((remove));
                soso.startAnimation((remove));
                G.startAnimation((remove));
                GG.startAnimation((remove));

                chi.setVisibility(View.VISIBLE);
                chi.startAnimation((bujuk));
                break;
            case 2:
                BB.startAnimation((remove));
                B.startAnimation((chose2));
                soso.startAnimation((remove));
                G.startAnimation((remove));
                GG.startAnimation((remove));
                hap.setVisibility(View.VISIBLE);
                hap.startAnimation((bujuk));
                break;
            case 3:
                BB.startAnimation((remove));
                B.startAnimation((remove));
                soso.startAnimation((chose3));
                G.startAnimation((remove));
                GG.startAnimation((remove));
                dae.setVisibility(View.VISIBLE);
                dae.startAnimation((bujuk));
                break;
            case 4:
                BB.startAnimation((remove));
                B.startAnimation((remove));
                soso.startAnimation((remove));
                G.startAnimation((chose4));
                GG.startAnimation((remove));
                gwang.setVisibility(View.VISIBLE);
                gwang.startAnimation((bujuk));
                break;
            default :
                break;
        }


        //도움말





        MoneyC = BOKCHAE - 200;
        Button go_to_frag_wed = (Button) findViewById(R.id.goToFragWed);

        go_to_frag_wed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMoney = new Intent();
                intentMoney.putExtra("BOKCHAE", MoneyC);
                setResult(RESULT_OK, intentMoney);
                finish();
            }
        });

    }

}
