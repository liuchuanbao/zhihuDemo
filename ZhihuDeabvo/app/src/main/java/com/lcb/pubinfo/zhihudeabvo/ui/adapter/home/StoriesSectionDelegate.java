package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/3/28.
 */


class StoriesSectionDelegate implements ItemViewDelegate<BaseItem> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof StoriesSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        if (position == 1) {
            holder.setText(R.id.story_section, "今日热闻");
        } else {
            holder.setText(R.id.story_section, ((StoriesSection) baseItem).getDate());
        }
    }
}