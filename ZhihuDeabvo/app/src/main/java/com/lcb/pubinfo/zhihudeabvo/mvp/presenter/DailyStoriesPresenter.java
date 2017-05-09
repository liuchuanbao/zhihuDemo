package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.DailyStoriesMoudle;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.IDailyStoriesMoudle;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IDailyStoriesView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/3/28.
 */

public class DailyStoriesPresenter extends IBasePresenter {

         private IDailyStoriesView mView;
    private IDailyStoriesMoudle module;
  public   DailyStoriesPresenter(IDailyStoriesView view){
      mView = view;
      module = new DailyStoriesMoudle();
  }
    public void getLatestStories(){
        Subscription subscription = module.getLatestStories()
                   .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LatestStories>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getLatestStories() 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(LatestStories latestStories) {
                        mView.loadLatestStories(latestStories);
                    }
                });
        addSubscription(subscription);
    }
     public  void getBeforeDaily(String date){
         Subscription subscriptions = module.getBeforeStories(date)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<BeforeStories>() {
                     @Override
                     public void onCompleted() {

                     }

                     @Override
                     public void onError(Throwable e) {
                         mView.onRequestError("getBeforeDaily 数据加载失败ヽ(≧Д≦)ノ");
                     }

                     @Override
                     public void onNext(BeforeStories beforeStories) {
                         mView.loadBeforeStories(beforeStories);
                     }
                 });
         addSubscription(subscriptions);
     }

}
