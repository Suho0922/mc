package com.suho.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class FragWednesday extends Fragment {
    private View view;
    TextView textView;

    public static FragWednesday newinstance(){
        FragWednesday fragWednesday = new FragWednesday();
        return fragWednesday;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_wednesday, container, false);


        Button button3 = (Button) view.findViewById(R.id.button3);
        final TextView textView3 = (TextView)view.findViewById(R.id.textView3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double random = Math.random() * 5d;
                if (random < 1d) {
                    textView3.setText("답도없다");
                } else if (random < 2d) {
                    textView3.setText("조금낫다");
                } else if (random < 3d) {
                    textView3.setText("평범");
                } else if (random < 4d) {
                    textView3.setText("행운");
                } else
                    textView3.setText("대박");
            }
        });
        return view;
    }
}
