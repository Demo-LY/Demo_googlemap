package com.example.leonwang.demo_google1003.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.leonwang.demo_google1003.Fragments.GoogleMapFragment;
import com.example.leonwang.demo_google1003.Fragments.MapsFragment;
import com.example.leonwang.demo_google1003.Fragments.SearchFragment;
import com.example.leonwang.demo_google1003.Fragments.UserInfoFragment;
import com.example.leonwang.demo_google1003.R;
import com.google.android.gms.location.LocationRequest;

public class MainActivity extends FragmentActivity  {

    private LocationRequest mLocationRequest;


    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private Class fragmentArray[] = {SearchFragment.class,MapsFragment.class,UserInfoFragment.class};
    private int mImageViewArray[] = {R.drawable.tab_googlemap_btn,R.drawable.tab_search_btn,R.drawable.tab_selfinfo_btn};
    private String mTextviewArray[] = {"Route", "Search", "User"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

      //  getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, getMapFragment()).commit();
    }



    private void initView(){
        layoutInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        int count = fragmentArray.length;

        for(int i = 0; i < count; i++){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }


    private View getTabItemView(int index){
        View view = layoutInflater.inflate(R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }

}
