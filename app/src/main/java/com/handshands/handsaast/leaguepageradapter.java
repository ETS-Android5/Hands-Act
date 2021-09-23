package com.handshands.handsaast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class leaguepageradapter extends FragmentPagerAdapter {
    private int numoftabs;

    public leaguepageradapter(@NonNull FragmentManager fm,int numoftabs) {
        super(fm);
        this.numoftabs=numoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new leaguematches();
            case 1:
                return new leaguetop();
            case 2:
                return new leaguegroups();
            case 3:
                return new leagueknockout();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }
}
