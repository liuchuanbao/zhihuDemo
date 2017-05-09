package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentExtra;

/**
 * Created by pubinfo on 2017/3/29.
 */

public interface IStoryContentView {
    void onRequestError(String msg);

    void loadStoryContent(StoryContent storyContent);

    void loadStoryContentExtra(StoryContentExtra storyContentExtra);
}
