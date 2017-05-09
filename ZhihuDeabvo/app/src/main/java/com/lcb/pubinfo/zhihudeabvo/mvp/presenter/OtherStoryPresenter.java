package com.lcb.pubinfo.zhihudeabvo.mvp.presenter;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeThemeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContent;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.IOtherStoriesModule;
import com.lcb.pubinfo.zhihudeabvo.mvp.module.OtherStoriesModule;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IOtherStoriesView;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class OtherStoryPresenter extends IBasePresenter {
     private  IOtherStoriesView mView;
    private   IOtherStoriesModule module;

   public OtherStoryPresenter(IOtherStoriesView view){
       mView = view;
       module = new OtherStoriesModule();
   }
    public void getOtherStories(int id){
        Subscription subscription = module.getOtherStories(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThemesContent>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getOtherStories 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(ThemesContent themesContent) {
                        mView.setStoryId(themesContent.getStories().get(themesContent.getStories().size() - 1).getId());
                        mView.loadStories(themesContent);
                    }
                });
        addSubscription(subscription);
    }
    public void getMoreThemeStories(int id, int story_id) {
        Subscription subscriptions = module.getMoreThemeStories(id, story_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BeforeThemeStories>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError("getThemesList 数据加载失败ヽ(≧Д≦)ノ");
                    }

                    @Override
                    public void onNext(BeforeThemeStories beforeThemeStories) {
                        mView.setStoryId(beforeThemeStories.getStories().get(beforeThemeStories.getStories().size() - 1).getId());
                        mView.loadMoreStories(beforeThemeStories);
                    }
                });
        addSubscription(subscriptions);
    }


}
