package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.Themes;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface IThemeView {
    void onRequestError(String msg);

    void loadThemeList(Themes themes);
}
