package com.example.leonwang.demo_google1003.Views;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.leonwang.demo_google1003.R;


public class LoadingDialog extends Dialog {

    Context context;
    private TextView message;

    public LoadingDialog(Context context) {
        super(context);
        this.context = context;
    }
    public LoadingDialog(Context context, int theme){
        super(context, theme);
        this.context = context;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.common_loading);
        message=(TextView) findViewById(R.id.message);
    }

    public void showMessage(){
        message.setVisibility(View.VISIBLE);
    }

    public void disableMessage(){
        message.setVisibility(View.GONE);
    }

}