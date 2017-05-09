package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/28.
 */

public class DailyStoriesMoudle implements IDailyStoriesMoudle {
    @Override
    public Observable<LatestStories> getLatestStories() {
        return ApiManage.getInstance().getCommonApi().getLatestStories();
    }

    @Override
    public Observable<BeforeStories> getBeforeStories(String date) {
        return ApiManage.getInstance().getCommonApi().getBeforeStories(date);
    }
}
