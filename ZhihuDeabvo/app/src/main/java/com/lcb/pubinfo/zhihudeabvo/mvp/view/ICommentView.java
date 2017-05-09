package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;

/**
 * Created by pubinfo on 2017/4/24.
 */

public interface ICommentView {
    void onRequestError(String msg);

    void loadStoryContentLongComments(StoryContentLongComment longComment);

    void loadStoryContentShortComments(StoryContentShortComment shortComment);
}
