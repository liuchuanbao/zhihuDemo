package com.lcb.pubinfo.zhihudeabvo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;
import com.lcb.pubinfo.zhihudeabvo.mvp.presenter.DailyStoriesPresenter;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IDailyStoriesView;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.home.StoriesHeader;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.home.StoriesListAdapter;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.home.StoriesSection;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pubinfo on 2017/3/28.
 */

public class DailyStoriesFragment extends Fragment implements IDailyStoriesView {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private DailyStoriesPresenter mPresenter;
    private final List<BaseItem> mItemList = new ArrayList<>();
    private LoadMoreWrapper mLoadMoreWrapper;
    private String date;
    private boolean isRefresh;

    public DailyStoriesFragment() {
        // Required empty public constructor
    }

    // 初始化view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_stories, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        return view;
    }
    // 初始化数据
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView();
    }

    private void initData() {
        mPresenter = new DailyStoriesPresenter(this);
        StoriesListAdapter adapter = new StoriesListAdapter(getContext(), mItemList);
        /**
         * 在添加头headView和footView的时候，将原来的adapter作为对象传入
         */
        mLoadMoreWrapper = new LoadMoreWrapper(adapter);
    }

    private void initView() {
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (date != null) {
                    mPresenter.getBeforeDaily(date);
                }
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mLoadMoreWrapper);
        mPresenter.getLatestStories();
        // 下拉刷新
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isRefresh = true;
                mPresenter.getLatestStories();
            }
        });
    }

    @Override
    public void onDestroy() {
        mPresenter.unSubscription();
        mItemList.clear();
        super.onDestroy();
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadLatestStories(LatestStories latestStories) {
        if (isRefresh) {
            mItemList.clear();
            mLoadMoreWrapper.notifyDataSetChanged();
        }
        date = latestStories.getDate();
        mItemList.add(new StoriesHeader(latestStories.getTop_stories()));
        mItemList.add(new StoriesSection(latestStories.getDate()));
        mItemList.addAll(latestStories.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
        isRefresh = true;
    }

    @Override
    public void loadBeforeStories(BeforeStories beforeStories) {
        date = beforeStories.getDate();
        mItemList.add(new StoriesSection(beforeStories.getDate()));
        mItemList.addAll(beforeStories.getStories());
        mLoadMoreWrapper.notifyDataSetChanged();
    }
}
