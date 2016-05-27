package com.example.sh.basetabfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sh.basetabfragment.R;

import java.util.List;

/**
 * Created by sh on 2016/5/25.
 */
public class BaseTabFragment extends Fragment {

    private View mView;
    private List<String> mTitles;
    private List<Fragment> mFragemnts;
    private TabLayout mTabLayout;
    private ViewPager  mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base_tab,container,false);
        this.mView = view;
        initView();
        return view;
    }

    private void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        buildTab();
        buildFragment();
    }


    private void buildTab(){
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        for(int i=0;i<mTitles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitles.get(i)));
        }
    }

    private void buildFragment(){
        mViewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public BaseTabFragment setTitles(List<String> tittles ){
        this.mTitles = tittles;
        return this;
    }
    public BaseTabFragment setFragments(List<Fragment> fragments){
        this.mFragemnts = fragments;
        return this;
    }

    private class TabPagerAdapter extends FragmentPagerAdapter{

        public TabPagerAdapter(FragmentManager fm ) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragemnts.get(position);
        }

        @Override
        public int getCount() {
            return mFragemnts.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}
