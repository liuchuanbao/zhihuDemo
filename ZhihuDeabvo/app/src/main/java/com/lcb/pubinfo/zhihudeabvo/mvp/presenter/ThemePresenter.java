package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.Themes;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.ThemeModule;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IThemeView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class ThemePresenter extends IBasePresenter {
   private IThemeView mView;
    private ThemeModule module;
    public ThemePresenter(IThemeView view){
        mView = view;
        module = new ThemeModule();
    }
    public void getThemesList(){
        Subscription subscription = module.getThemesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Themes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getThemesList 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(Themes themes) {
                        mView.loadThemeList(themes);
                    }
                });
        addSubscription(subscription);
    }
}
