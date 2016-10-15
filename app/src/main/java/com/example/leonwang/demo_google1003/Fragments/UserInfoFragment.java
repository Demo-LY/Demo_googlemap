package com.example.leonwang.demo_google1003.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.leonwang.demo_google1003.R;
import com.example.leonwang.demo_google1003.Utils.TranseTools;
import com.example.leonwang.demo_google1003.mains.UserApplication;

/**
 * Created by Leon.wang on 2016/9/18.
 */
public class UserInfoFragment extends BaseFragment {

    private View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_userinfo_main, container, false);
            //user account 用户账户
            mView.findViewById(R.id.myaccountinfor).setOnClickListener(this);
            //travel history 我的历史
            mView.findViewById(R.id.myHistory).setOnClickListener(this);
            //users' collection 我的收藏
            mView.findViewById(R.id.myCollection).setOnClickListener(this);
            //offline maps 离线地图下载
            mView.findViewById(R.id.OfflineMaps).setOnClickListener(this);
            //offline maps set 离线地图存储位置
            mView.findViewById(R.id.InternalStorage).setOnClickListener(this);
            //Setting 设置
            mView.findViewById(R.id.Setting).setOnClickListener(this);
        }

        ViewGroup parent = (ViewGroup) mView.getParent();
        if (parent != null)
        {
            parent.removeView(mView);
        }

        return mView;

    }

    @Override
    public void onClick(View v ) {
        switch (v.getId()) {
            case R.id.myaccountinfor:
                TranseTools.pushFragMents(getMActivity(), new MyAccountInforFragment(), 1,
                        true, false, true, null);
                break;
            case R.id.myHistory:
                TranseTools.pushFragMents(getMActivity(), new MyHistoryFragment(), 1,
                        true, false, true, null);
                break;
            case R.id.myCollection:
                TranseTools.pushFragMents(getMActivity(), new MyCollectionFragment(), 1,
                        true, false, true, null);
                break;
            case R.id.OfflineMaps:
                TranseTools.pushFragMents(getMActivity(), new OffLineMapsFragment(), 1,
                        true, false, true, null);
                break;

            case R.id.InternalStorage:
                TranseTools.pushFragMents(getMActivity(), new InternalStorageFragment(), 1,
                        true, false, true, null);
                break;
            case R.id.Setting:
                TranseTools.pushFragMents(getMActivity(), new SettingFragments(), 1,
                        true, false, true, null);
                break;
        }
    }
}
