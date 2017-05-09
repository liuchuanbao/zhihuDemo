package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/28.
 */

public interface IDailyStoriesMoudle {

    Observable<LatestStories> getLatestStories();

    Observable<BeforeStories> getBeforeStories(String date);
}
