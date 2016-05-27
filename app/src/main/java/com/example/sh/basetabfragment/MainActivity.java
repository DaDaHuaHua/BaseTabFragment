package com.example.sh.basetabfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.sh.basetabfragment.fragment.BaseTabFragment;
import com.example.sh.basetabfragment.fragment.MyFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<String> mTittles;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;
    private FrameLayout mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContent = (FrameLayout) findViewById(R.id.content);
        initData();
    }

    private void initData() {
        mTittles = new ArrayList<>();
        mFragments = new ArrayList<>();
        for(int i=0;i<4;i++){
            mTittles.add("标题"+i);
            mFragments.add(new MyFragment());
        }
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.content,new BaseTabFragment().setTitles(mTittles).setFragments(mFragments)).commit();

    }


}
