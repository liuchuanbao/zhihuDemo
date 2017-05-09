package com.lcb.pubinfo.zhihudeabvo.mvp.view;

import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;

/**
 * Created by pubinfo on 2017/3/28.
 */

public interface IDailyStoriesView {
      void onRequestError(String msg);

     void loadLatestStories(LatestStories latestStories);

    void loadBeforeStories(BeforeStories beforeStories);

}
