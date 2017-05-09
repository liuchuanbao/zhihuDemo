package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;


import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.utils.DateUtils;

/**
 * Created by OO on 2017/2/14.
 */

public class StoriesSection implements BaseItem {
    private final String date;

    public StoriesSection(String date) {
        this.date = date;
    }

    public String getDate() {
        if (date == null) {
            return null;
        }
        return DateUtils.transform(date);
    }
}
