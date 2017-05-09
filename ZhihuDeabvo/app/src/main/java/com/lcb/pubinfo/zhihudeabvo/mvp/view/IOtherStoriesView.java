package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeThemeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContent;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface IOtherStoriesView {
    void onRequestError(String msg);
    void setStoryId(int storyId);
    void loadStories(ThemesContent themesContet);

    void loadMoreStories(BeforeThemeStories beforeThemeStories);
}
