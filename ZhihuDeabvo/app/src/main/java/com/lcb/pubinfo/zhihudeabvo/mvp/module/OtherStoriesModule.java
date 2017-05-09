package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.BeforeThemeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContent;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class OtherStoriesModule implements IOtherStoriesModule{
    @Override
    public Observable<ThemesContent> getOtherStories(int id) {
        return ApiManage.getInstance().getCommonApi().getThemesContent(id);
    }

    @Override
    public Observable<BeforeThemeStories> getMoreThemeStories(int id, int story_id) {
        return ApiManage.getInstance().getCommonApi().getBeforeThemesContent(id, story_id);
    }
}
