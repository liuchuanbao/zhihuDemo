package com.lcb.pubinfo.zhihudeabvo.ui.adapter.other;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.Editors;
import com.lcb.pubinfo.zhihudeabvo.ui.activity.EditorListActivity;
import com.lcb.pubinfo.zhihudeabvo.widget.CircleTransform;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class OtherStoriesSectionDelegate implements ItemViewDelegate<BaseItem> {

    private Context mContext;

    @Override
    public int getItemViewLayoutId() {
        return R.layout.item_other_story_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof OtherStoriesSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        mContext = holder.getConvertView().getContext();
        final OtherStoriesSection section = (OtherStoriesSection) baseItem;
        LinearLayout editorGroup = holder.getView(R.id.editor_group);
        if (editorGroup.getChildCount() == 0) {
            for (Editors editors : section.getEditors()) {
                ImageView imageView = new ImageView(mContext);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                Glide.with(mContext)
                        .load(editors.getAvatar())
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .transform(new CircleTransform(mContext))
                        .into(imageView);
                editorGroup.addView(imageView);
            }
        }
        holder.getView(R.id.editors).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditorListActivity.class);
                intent.putParcelableArrayListExtra("editorList", section.getEditors());
                mContext.startActivity(intent);
            }
        });
    }

}
