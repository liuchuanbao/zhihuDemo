package com.lcb.pubinfo.zhihudeabvo.ui.adapter.other;

import android.content.Context;

import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class OtherStoriesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public OtherStoriesListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new OtherStoriesHeaderDelegate());
        addItemViewDelegate(new OtherStoriesSectionDelegate());
        addItemViewDelegate(new OtherStoriesItemDelegate());
    }
}
