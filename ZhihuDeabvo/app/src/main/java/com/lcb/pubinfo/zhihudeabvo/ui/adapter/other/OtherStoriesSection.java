package com.lcb.pubinfo.zhihudeabvo.ui.adapter.other;

import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.Editors;

import java.util.ArrayList;


/**
 * Created by OO on 2017/2/28.
 */

public class OtherStoriesSection implements BaseItem {
    private final ArrayList<Editors> mEditors;

    public OtherStoriesSection(ArrayList<Editors> editors) {
        mEditors = editors;
    }

    public ArrayList<Editors> getEditors() {
        return mEditors;
    }
}
