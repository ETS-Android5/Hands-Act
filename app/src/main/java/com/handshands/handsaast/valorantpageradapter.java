package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class valorantpageradapter extends FragmentPagerAdapter {
    private int numoftabs;
    public valorantpageradapter(@NonNull FragmentManager fm, int numoftabs) {
        super(fm);
        this.numoftabs=numoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new matchesvalorant();
            case 1:
                return new topvalorant();
            case 2:
                return new groupsvalorant();
            case 3:
                return new knockoutvalorant();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
