package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;


import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.TopStories;

import java.util.List;

/**
 * Created by OO on 2017/2/15.
 */

public class StoriesHeader implements BaseItem {
    private final List<TopStories> mTopStories;

    public StoriesHeader(List<TopStories> topStories) {
        mTopStories = topStories;
    }


    public List<TopStories> getTopStories() {
        return mTopStories;
    }

}
