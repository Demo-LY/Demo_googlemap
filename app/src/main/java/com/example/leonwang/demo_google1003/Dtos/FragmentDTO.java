package com.example.leonwang.demo_google1003.Dtos;

import android.support.v4.app.Fragment;


public class FragmentDTO {
	private Fragment fragment;
	private int tabidx = -1 ;
	public Fragment getFragment() {
		return fragment;
	}
	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}
	public int getTabidx() {
		return tabidx;
	}
	public void setTabidx(int tabidx) {
		this.tabidx = tabidx;
	}
	
}