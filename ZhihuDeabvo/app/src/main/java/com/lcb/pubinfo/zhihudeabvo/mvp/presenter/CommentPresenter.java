package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.CommentModul;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.ICommentView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/4/24.
 */

public class CommentPresenter extends IBasePresenter {
    private CommentModul modul;
      private ICommentView mView;
   public  CommentPresenter(ICommentView activity){
       mView = activity;
       modul = new CommentModul();
   }
   public void getStoryContentLongComments(int id){
       Subscription subscription = modul.getStoryContentLongComments(id)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<StoryContentLongComment>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {
                       mView.onRequestError("getStoryContentLongComments 数据加载失败ヽ(≧Д≦)ノ");
                   }

                   @Override
                   public void onNext(StoryContentLongComment longComment) {
                       mView.loadStoryContentLongComments(longComment);
                   }
               });
       addSubscription(subscription);
   }

    public void getStoryContentShortComment(int id){
        Subscription subscription = modul.getStoryContentShortComments(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryContentShortComment>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getStoryContentShortComments 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(StoryContentShortComment shortComment) {
                        mView.loadStoryContentShortComments(shortComment);
                    }
                });
        addSubscription(subscription);
    }

}
