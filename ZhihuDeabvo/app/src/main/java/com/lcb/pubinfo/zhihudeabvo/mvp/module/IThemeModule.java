package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.Themes;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface IThemeModule {
    Observable<Themes> getThemesList();
}
