package com.lcb.pubinfo.zhihudeabvo.mvp.module;

import com.lcb.pubinfo.zhihudeabvo.api.ApiManage;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;

import rx.Observable;

/**
 * Created by pubinfo on 2017/4/24.
 */

public class CommentModul implements ICommentModul {
    @Override
    public Observable<StoryContentLongComment> getStoryContentLongComments(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContentLongComments(id);
    }

    @Override
    public Observable<StoryContentShortComment> getStoryContentShortComments(int id) {
        return ApiManage.getInstance().getCommonApi().getStoryContentShortComments(id);
    }
}
