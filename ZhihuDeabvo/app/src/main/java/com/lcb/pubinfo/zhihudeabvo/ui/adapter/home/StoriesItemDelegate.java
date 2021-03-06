package com.lcb.pubinfo.zhihudeabvo.ui.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.Stories;
import com.lcb.pubinfo.zhihudeabvo.ui.activity.StoryContentActivity;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/3/28.
 */


class StoriesItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof Stories;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {

        final Stories stories = (Stories) baseItem;
        holder.setText(R.id.title, stories.getTitle());
        if (stories.isMultiPic()) {
            holder.getView(R.id.multiPic).setVisibility(View.VISIBLE);
        } else {
            holder.getView(R.id.multiPic).setVisibility(View.INVISIBLE);
        }
        mContext = holder.getConvertView().getContext();
        Glide.with(mContext)
                .load(stories.getImages().get(0))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into((ImageView) holder.getView(R.id.image));
        holder.setOnClickListener(R.id.cardView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, StoryContentActivity.class);
                intent.putExtra("id", stories.getId());
                mContext.startActivity(intent);
            }
        });
    }

}
