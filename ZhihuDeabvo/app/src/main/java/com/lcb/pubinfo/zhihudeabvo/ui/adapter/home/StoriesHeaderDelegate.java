package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;

import android.content.Context;
import android.content.Intent;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.widget.Banner.Banner;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/3/28.
 */

public class StoriesHeaderDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_header;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof StoriesHeader;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final StoriesHeader storiesHeader = (StoriesHeader) baseItem;
        Banner banner = holder.getView(R.id.banner);
        banner.setDataList(storiesHeader.getTopStories())
                .start();

        banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void OnBannerClick(int id) {
//                Intent intent = new Intent(mContext,StoryContentActivity.class);
//                intent.putExtra("id", id);
//                mContext.startActivity(intent);
            }
        });
    }
}
