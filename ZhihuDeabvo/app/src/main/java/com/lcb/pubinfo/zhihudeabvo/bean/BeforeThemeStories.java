package com.lcb.pubinfo.zhihudeabvo.bean;

import java.util.List;

/**
 * Created by OO on 2017/3/8.
 */

public class BeforeThemeStories implements BaseItem {

    private List<ThemesContentItem> stories;

    public List<ThemesContentItem> getStories() {
        return stories;
    }

    public void setStories(List<ThemesContentItem> stories) {
        this.stories = stories;
    }

}
