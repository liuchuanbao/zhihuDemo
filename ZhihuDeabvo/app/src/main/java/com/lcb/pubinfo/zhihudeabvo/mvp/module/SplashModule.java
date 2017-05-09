package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class SplashModule  implements ISplashModule {
    @Override
    public Observable<LaunchImage> getLaunchImage() {
        return  ApiManage.getInstance().getCommonApi().getLaunchImage();
    }
}
