package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.Themes;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class ThemeModule  implements IThemeModule{
    @Override
    public Observable<Themes> getThemesList() {
        return ApiManage.getInstance().getCommonApi().getThemesList();
    }
}
