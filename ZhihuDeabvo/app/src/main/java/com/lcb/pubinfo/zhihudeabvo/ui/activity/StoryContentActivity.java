package com.lcb.pubinfo.zhihudeabvo.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;


public class StoryContentActivity  extends  BaseActivity{

    private ImageView mImageView;
    private TextView title;
    private TextView imageSource;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_story_content;
    }

    @Override
    protected void setHeaderImg() {
        imageSource = (TextView) findViewById(R.id.image_source);
        mImageView = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
    }

    @Override
    protected void loadHeaderImg(StoryContent storyContent) {
        title.setText(storyContent.getTitle());
        imageSource.setText(storyContent.getImage_source());
        Glide.with(this)
                .load(storyContent.getImage())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);
    }



}
