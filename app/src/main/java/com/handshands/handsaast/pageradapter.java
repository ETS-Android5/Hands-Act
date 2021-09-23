package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class    pageradapter extends FragmentPagerAdapter {
    private int numoftabs;
    public pageradapter(@NonNull FragmentManager fm,int numoftabs) {
        super(fm);
        this.numoftabs=numoftabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new livescorce();
            case 1:
                return new lastscorces();
            case 2:
                return new tops();
            case 3:
                return new groupafragment();
            case 4:
                return new groupbfragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
