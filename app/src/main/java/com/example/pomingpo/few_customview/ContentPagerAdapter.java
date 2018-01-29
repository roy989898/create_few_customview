package com.example.pomingpo.few_customview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by roy.leung on 29/1/2018.
 */

public class ContentPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragmentArrayList;

    public ArrayList<Fragment> getFragmentArrayList() {
        return fragmentArrayList;
    }

    public void setFragmentArrayList(ArrayList<Fragment> fragmentArrayList) {
        this.fragmentArrayList = fragmentArrayList;
    }

    public ContentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        if (fragmentArrayList == null)
            return 0;
        else
            return fragmentArrayList.size();
    }
}
