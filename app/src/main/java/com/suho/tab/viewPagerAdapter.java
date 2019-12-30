package com.suho.tab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class viewPagerAdapter extends FragmentPagerAdapter {
    public viewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
//fragment 교체를 보여주는 처리를 구현한 곳
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return FragMonday.newinstance();
            case 1:
                return FragTuseday.newinstance();
            case 2:
                return FragWednesday.newinstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; //fragment 개수
    }

    //상단의 탭 레이아웃 인디케이터 쪽에 텍스트를 선언해주는곳
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "연락처";
            case 1:
                return "앨범";
            case 2:
                return "자유";
            default:
                return null;
        }

    }
}
