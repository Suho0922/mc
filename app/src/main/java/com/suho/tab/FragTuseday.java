package com.suho.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragTuseday extends Fragment{
    private View view;

    public static FragTuseday newinstance(){
        FragTuseday fragTuseday = new FragTuseday();
        return fragTuseday;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_tuseday, container, false);

        return view;

    }
}

