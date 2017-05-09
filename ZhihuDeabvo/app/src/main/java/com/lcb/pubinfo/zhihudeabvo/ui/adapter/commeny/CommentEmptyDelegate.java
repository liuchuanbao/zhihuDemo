package com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/4/24.
 */

public class CommentEmptyDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.empty_long_comment;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof CommentEmpty;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

    }
}
