package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentExtra;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.StoryContentMoudle;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IStoryContentView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/4/6.
 */

public class StoryContentPresenter extends IBasePresenter {
    private final IStoryContentView mView;
    private final StoryContentMoudle mStoryContentBiz;

    public StoryContentPresenter(IStoryContentView view) {
        mView = view;
        mStoryContentBiz = new StoryContentMoudle();
    }
    public void getStoryContent(int id) {
        Subscription subscription = mStoryContentBiz.getStoryContent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryContent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getStoryContent 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(StoryContent storyContent) {
                        mView.loadStoryContent(storyContent);
                    }
                });
        addSubscription(subscription);
    }

    public void getStoryContentExtra(int id) {
        Subscription subscription = mStoryContentBiz.getStoryContentExtra(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<StoryContentExtra>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getStoryContentExtra 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(StoryContentExtra storyContentExtra) {
                        mView.loadStoryContentExtra(storyContentExtra);
                    }
                });
        addSubscription(subscription);
    }
}
