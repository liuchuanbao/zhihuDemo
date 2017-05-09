package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;

import android.content.Context;

import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by pubinfo on 2017/3/28.
 */

public class StoriesListAdapter extends MultiItemTypeAdapter<BaseItem> {
    public StoriesListAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new StoriesHeaderDelegate());
        addItemViewDelegate(new StoriesSectionDelegate());
        addItemViewDelegate(new StoriesItemDelegate());
    }
}
