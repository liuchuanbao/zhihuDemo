package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentExtra;

import rx.Observable;

/**
 * Created by pubinfo on 2017/4/6.
 */

public interface IStoryContentMoudle {
    Observable<StoryContent> getStoryContent(int id);

    Observable<StoryContentExtra> getStoryContentExtra(int id);
}
