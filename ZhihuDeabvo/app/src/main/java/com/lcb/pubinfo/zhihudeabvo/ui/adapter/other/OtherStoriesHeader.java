package com.lcb.pubinfo.zhihudeabvo.ui.adapter.other;


import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;

/**
 * Created by OO on 2017/2/27.
 */

public class OtherStoriesHeader implements BaseItem {
    private final String url;
    private final String description;

    public OtherStoriesHeader(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
