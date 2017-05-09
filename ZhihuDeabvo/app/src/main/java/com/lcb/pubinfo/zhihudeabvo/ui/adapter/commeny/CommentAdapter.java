package com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny;

import android.content.Context;

import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.List;

/**
 * Created by pubinfo on 2017/4/24.
 */

public class CommentAdapter extends MultiItemTypeAdapter<BaseItem> {
    public CommentAdapter(Context context, List<BaseItem> datas) {
        super(context, datas);
        addItemViewDelegate(new CommentSectionDelegate());
        addItemViewDelegate(new CommentEmptyDelegate());
        addItemViewDelegate(new CommentItemDelegate());

    }
}
