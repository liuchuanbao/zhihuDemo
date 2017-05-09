package com.lcb.pubinfo.zhihudeabvo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;
import com.lcb.pubinfo.zhihudeabvo.mvp.presenter.CommentPresenter;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.ICommentView;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny.CommentAdapter;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny.CommentEmpty;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny.CommentSection;
import com.lcb.pubinfo.zhihudeabvo.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity  implements ICommentView{


    private final List<BaseItem> mItemList = new ArrayList<>();
    private CommentPresenter mPresenter;
private CommentAdapter mAdapter;


    private int id;
    private int longCommentNum;
    private int shortCommentNum;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        initView();
        initData();
        
    }

    private void initData() {
        id = getIntent().getIntExtra("id", 0);
        int commentNum = getIntent().getIntExtra("comment_num", 0);
        longCommentNum = getIntent().getIntExtra("long_comment_num", 0);
        shortCommentNum = getIntent().getIntExtra("short_comment_num", 0);
        if (id != 0) {
            mPresenter.getStoryContentLongComments(id);
        } else {
            Toast.makeText(this, "数据加载出错", Toast.LENGTH_SHORT).show();
        }
        setTitle(commentNum + "条点评");
    }

    private void initView() {
        initToolBar();
        mPresenter = new CommentPresenter(this);
        mAdapter = new CommentAdapter(this, mItemList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_comment);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(CommentActivity.this,DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(mAdapter);
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadStoryContentLongComments(StoryContentLongComment longComment) {
        mItemList.add(new CommentSection(longCommentNum, CommentSection.LONG_COMMENT));
        if (longCommentNum != 0) {
            mItemList.addAll(longComment.getComments());
        } else {
            mItemList.add(new CommentEmpty());
        }
        mPresenter.getStoryContentShortComment(id);
    }

    @Override
    public void loadStoryContentShortComments(StoryContentShortComment shortComment) {
        mItemList.add(new CommentSection(shortCommentNum, CommentSection.SHORT_COMMENT));
        mItemList.addAll(shortComment.getComments());
        mAdapter.notifyDataSetChanged();
    }
}
