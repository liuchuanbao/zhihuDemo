package com.lcb.pubinfo.zhihudeabvo.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;
import com.lcb.pubinfo.zhihudeabvo.mvp.presenter.SplashPresenter;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.ISplashView;
import com.lcb.pubinfo.zhihudeabvo.utils.SharedPreferencesUtils;

public class SplashActivity extends AppCompatActivity implements ISplashView{

    private ImageView launchImage;
    private String imgUrl;
    private SplashPresenter mPresenter;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what ==10086){
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
            super.handleMessage(msg);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        launchImage = (ImageView) findViewById(R.id.launch_image);
        mPresenter = new SplashPresenter(this);
        mPresenter.getLaunchImage();
    }

    @Override
    public void onRequestError() {
      imgUrl  = (String) SharedPreferencesUtils.get(this,"launch_image","");
        if(TextUtils.isEmpty(imgUrl)){
            Glide.with(this)
                    .load(imgUrl)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(launchImage);
        }
    }

    @Override
    public void getLaunchImage(LaunchImage image) {
        imgUrl = image.getCreatives().get(0).getUrl();
        Glide.with(this)
                .load(imgUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(launchImage);
        SharedPreferencesUtils.put(this, "launch_image", imgUrl);
    }

    @Override
    public void onRequestEnd() {
        Message message = new Message();
        message.what = 10086;
        mHandler.sendMessageDelayed(message, 3000);
    }

    @Override
    protected void onDestroy() {
        mPresenter.unSubscription();
        super.onDestroy();
    }
}
