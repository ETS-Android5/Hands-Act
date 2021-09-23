package com.handshands.handsaast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class leagueoflegends extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leagueoflegends);
        tableLayout=findViewById(R.id.mytaps1);
        pager=findViewById(R.id.mypaper2);
        leaguepageradapter pagerAdapter=new leaguepageradapter(getSupportFragmentManager(),tableLayout.getTabCount());
        pager.setAdapter(pagerAdapter);
        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayout));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slideinleft,R.anim.slideoutright);
    }
}