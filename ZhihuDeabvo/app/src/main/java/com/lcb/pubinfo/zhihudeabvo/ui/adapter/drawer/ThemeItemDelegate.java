package com.lcb.pubinfo.zhihudeabvo.ui.adapter.drawer;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesOther;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class ThemeItemDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.drawer_list_item;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof ThemesOther;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        ThemesOther themesItem = (ThemesOther) baseItem;
        holder.setText(R.id.theme_title, themesItem.getName());
    }
}
