package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentExtra;

import rx.Observable;

/**
 * Created by pubinfo on 2017/4/6.
 */

public class StoryContentMoudle implements IStoryContentMoudle {
    @Override
    public Observable<StoryContent> getStoryContent(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContent(id);
    }

    @Override
    public Observable<StoryContentExtra> getStoryContentExtra(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContentExtra(id);
    }
}
