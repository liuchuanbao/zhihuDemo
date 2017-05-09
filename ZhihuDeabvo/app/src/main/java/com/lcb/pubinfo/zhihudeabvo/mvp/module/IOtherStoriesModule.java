package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeThemeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContent;

import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface IOtherStoriesModule {
    Observable<ThemesContent>  getOtherStories(int id);

    Observable<BeforeThemeStories> getMoreThemeStories(int id,int story_id);
}
