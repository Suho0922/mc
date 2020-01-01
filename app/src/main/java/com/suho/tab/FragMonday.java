package com.suho.tab;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;


public class FragMonday extends ListFragment {

    public static final int REQUEST_CODE_INSERT = 101;

    public static FragMonday newinstance(){
        FragMonday fragMonday = new FragMonday();
        return fragMonday;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_INSERT){
            String NAME = data.getExtras().getString("MoneyI");
            String PHONE_NUMBER = data.getExtras().getString("HorseI");

            adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test1), NAME, PHONE_NUMBER);

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();
        }
    }

    ListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Adapter 생성 및 Adapter 지정.
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test1), "Yang", "010-4531-1879");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test3), "Kim", "010-8417-7184");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test4), "Jung", "010-1657-4813");
        // 네 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test5), "Lee", "010-7324-8534");
        // 다섯 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test6), "Park", "010-1275-5342");
        // 여섯 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test7), "Yoo", "010-7241-4341");
        // 일곱 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test2), "Choi", "010-6824-5167");

        /*********
        Bundle extra = getArguments();
        if(extra != null) {
            //extra = getArguments();
            String NAME = extra.getString("NAME");
            String PHONE_NUMBER = extra.getString("PHONE_NUMBER");

            addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test1), NAME, PHONE_NUMBER);
        }
        **********/
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    /**************************************
    @Override
    public void onPause(){

        Bundle extra = getArguments();
        if(extra != null) {
            //extra = getArguments();
            String NAME = extra.getString("NAME");
            String PHONE_NUMBER = extra.getString("PHONE_NUMBER");

            addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test1), NAME, PHONE_NUMBER);
        }

        super.onPause();

    }
    *****************************************/

    /**************
    public void addItem(Drawable icon, String title, String desc) {
        adapter.addItem(icon, title, desc) ;
    }
    ***************/


    /************
    public void onSaveInstanceState(Bundle bundle){
        Bundle extra = getArguments();
        if(extra != null){
            //extra = getArguments();
            String NAME = extra.getString("NAME");
            String PHONE_NUMBER = extra.getString("PHONE_NUMBER");

            addItem(ContextCompat.getDrawable(getActivity(), R.drawable.ic_account_test1), NAME, PHONE_NUMBER);
        }
    }
     *************/



    /******************************************************
     * 혹시 모를 클릭 이벤트 처리를 위하여
    @Override
    public void onListItemClick (ListView l, View v, int position, long id) {
        // get TextView's Text.
        ListViewItem item = (ListViewItem) l.getItemAtPosition(position) ;

        String titleStr = item.getTitle() ;
        String descStr = item.getDesc() ;
        Drawable iconDrawable = item.getIcon() ;

        // TODO : use item data.
    }
    ********************************************************/

}

