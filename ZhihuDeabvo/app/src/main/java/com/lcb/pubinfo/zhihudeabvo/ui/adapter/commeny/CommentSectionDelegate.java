package com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny;

import android.view.View;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by pubinfo on 2017/4/24.
 */

public class CommentSectionDelegate  implements ItemViewDelegate<BaseItem>{
    @Override
    public int getItemViewLayoutId() {
        return R.layout.comment_item_section;
    }

    @Override
    public boolean isForViewType(BaseItem item, int position) {
        return item instanceof CommentSection;
    }

    @Override
    public void convert(ViewHolder holder, BaseItem baseItem, int position) {
        CommentSection commentSection = (CommentSection) baseItem;
        holder.setText(R.id.comment_num, commentSection.getTitle());
        if (commentSection.getType() == CommentSection.LONG_COMMENT) {
            holder.getView(R.id.comment_item_img).setVisibility(View.GONE);
        }
    }
}
