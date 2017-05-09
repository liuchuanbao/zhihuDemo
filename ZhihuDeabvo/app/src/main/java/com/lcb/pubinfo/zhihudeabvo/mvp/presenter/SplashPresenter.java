package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.SplashModule;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.ISplashView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class SplashPresenter extends  IBasePresenter{
    private SplashModule module;
    private ISplashView mView;
    public SplashPresenter(ISplashView view){
        this.mView = view;
        module = new SplashModule();
    }
    public void getLaunchImage(){
        Subscription subscription = module.getLaunchImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LaunchImage>() {
                    @Override
                    public void onCompleted() {
                        mView.onRequestEnd();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError();
                        mView.onRequestEnd();
                    }

                    @Override
                    public void onNext(LaunchImage launchImage) {
                        mView.getLaunchImage(launchImage);
                    }
                });
        addSubscription(subscription);
    }

}
