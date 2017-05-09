package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface ISplashModule {
    Observable<LaunchImage> getLaunchImage();
}
