package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;

import rx.Observable;

/**
 * Created by pubinfo on 2017/4/24.
 */

public interface ICommentModul {
    Observable<StoryContentLongComment> getStoryContentLongComments(int id);

    Observable<StoryContentShortComment> getStoryContentShortComments(int id);
}
