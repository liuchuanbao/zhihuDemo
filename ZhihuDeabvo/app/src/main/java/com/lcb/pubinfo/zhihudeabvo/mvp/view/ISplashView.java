package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface ISplashView {
    void onRequestError();

    void getLaunchImage(LaunchImage launchImage);

    void onRequestEnd();
}
