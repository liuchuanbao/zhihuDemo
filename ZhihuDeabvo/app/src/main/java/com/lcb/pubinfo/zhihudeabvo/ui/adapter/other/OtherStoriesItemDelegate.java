package com.lcb.pubinfo.zhihudeabvo.ui.adapter.other;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContentItem;
import com.lcb.pubinfo.zhihudeabvo.ui.activity.OtherStoryContentActivity;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;


/**
 * Created by OO on 2017/2/28.
 */

class OtherStoriesItemDelegate implements ItemViewDelegate<BaseItem> {
    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_story_list;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof ThemesContentItem;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final ThemesContentItem item = (ThemesContentItem) baseItem;
        holder.setText(R.id.title, item.getTitle());
        holder.getView(R.id.multiPic).setVisibility(View.GONE);
        if (item.getImages() != null) {
            Glide.with(mContext)
                    .load(item.getImages().get(0))
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into((ImageView) holder.getView(R.id.image));
        } else {
            holder.getView(R.id.image).setVisibility(View.GONE);
        }
        holder.setOnClickListener(R.id.cardView, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OtherStoryContentActivity.class);
                intent.putExtra("id", item.getId());
                mContext.startActivity(intent);
            }
        });
    }
}
