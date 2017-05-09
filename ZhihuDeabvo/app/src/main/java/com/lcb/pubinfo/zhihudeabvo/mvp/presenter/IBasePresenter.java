package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * 封装持有的网络请求的生命周期
 */

public class IBasePresenter {
     private CompositeSubscription  mCompositeSubscription;
    void  addSubscription(Subscription s){
        if(this.mCompositeSubscription ==null){
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }
    public  void unSubscription(){
         if(this.mCompositeSubscription!=null){
             this.mCompositeSubscription.unsubscribe();
         }
    }
}
