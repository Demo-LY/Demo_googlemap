package com.example.leonwang.demo_google1003.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leonwang.demo_google1003.R;
import com.example.leonwang.demo_google1003.Utils.ConfigManager;
import com.example.leonwang.demo_google1003.Utils.QLog;
import com.example.leonwang.demo_google1003.Utils.UserConf;
import com.example.leonwang.demo_google1003.Views.LoadingDialog;
import android.view.View.OnClickListener;
import java.io.IOException;
import java.net.UnknownHostException;

public abstract class BaseFragment extends Fragment implements OnClickListener{
	public FragmentActivity mActivity; //将MainActivity改为FragmentActivity 便于其它Activity也能应用此类
	protected Bundle transeferArgs;// Fragment只进行数据传递过来的值
	protected SharedPreferences preferences;
	protected LoadingDialog progressDialog; // 自定义loading
	public static UserConf userconf;
	protected ConfigManager configManager;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = getActivity();
		init();
	}

	protected FragmentActivity getMActivity() {
		return mActivity;
	}

    protected Resources getMResources() {
        return getMActivity().getResources();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        if(isAdded()){
            super.startActivityForResult(intent, requestCode);
        }else{
            QLog.error(getClass().getSimpleName(), "startActivityForResult not added");
        }
    }

	@Override
	public void startActivity(Intent intent) {
		if(isAdded()){
			super.startActivity(intent);
		}else{
			QLog.error(getClass().getSimpleName(), "startActivity not added");
		}
	}

	public void init() {
		transeferArgs = getArguments();
		preferences = mActivity.getSharedPreferences("nes",Context.MODE_PRIVATE);

		progressDialog = new LoadingDialog(mActivity, R.style.dialog);
		progressDialog.setCancelable(true);
		progressDialog.setCanceledOnTouchOutside(true);

		// 创建全局用户对象
		userconf = getUserconf();
		configManager=new ConfigManager(this.getActivity());
	}

	public static UserConf getUserconf() {

		try {
			userconf = UserConf.getInstance();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return userconf;
	}

    public static void setUserconf(UserConf userconf) {
        BaseFragment.userconf = userconf;
    }



	@Override
	public void setMenuVisibility(boolean menuVisible) {
		if(getView()!=null){
			getView().setVisibility(menuVisible? View.VISIBLE: View.GONE);
		}
		super.setMenuVisibility(menuVisible);
	}
}
