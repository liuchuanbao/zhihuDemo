package com.lcb.pubinfo.zhihudeabvo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lcb.pubinfo.zhihudeabvo.R;
import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;
import com.lcb.pubinfo.zhihudeabvo.bean.Themes;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesOther;
import com.lcb.pubinfo.zhihudeabvo.mvp.presenter.ThemePresenter;
import com.lcb.pubinfo.zhihudeabvo.mvp.view.IThemeView;
import com.lcb.pubinfo.zhihudeabvo.ui.activity.MainActivity;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.drawer.DrawerHeader;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.drawer.DrawerHome;
import com.lcb.pubinfo.zhihudeabvo.ui.adapter.drawer.ThemesListAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by pubinfo on 2017/3/27.
 */

public class ChooseThemeFragment extends Fragment implements IThemeView{

    private RecyclerView navView;

    private ThemePresenter mPresenter;
    private final List<BaseItem> mList = new ArrayList<>();

    private ThemesListAdapter mAdapter;

    private OtherStoriesFragment mOtherStoriesFragment;
    private DailyStoriesFragment mDailyStoriesFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_choose_theme, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navView = (RecyclerView) view.findViewById(R.id.nav_view);

        mPresenter = new ThemePresenter(this);


        mAdapter = new ThemesListAdapter(getContext(), mList);


        mDailyStoriesFragment = new DailyStoriesFragment();

        mAdapter.setOnItemClickListener(new ThemesListAdapter.OnItemClickListener() {

            @Override
            public void onDrawerHeaderClick(View view) {
                switch (view.getId()) {
                    case R.id.download:
                        Toast.makeText(getContext(), "正在离线下载最新内容", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        ((MainActivity)getActivity()).goToLogin();
                        break;
                }
            }

            @Override
            public void onItemViewClick(int position) {
                mAdapter.setSelection(position);
                mAdapter.notifyDataSetChanged();
                MainActivity activity = (MainActivity) getActivity();
                if (position != 1) {
                    int id = ((ThemesOther) mAdapter.getDatas().get(position)).getId();
                    String title = ((ThemesOther) mAdapter.getDatas().get(position)).getName();
                    mOtherStoriesFragment = OtherStoriesFragment.newInstance(id);
                    activity.switchFragment(mOtherStoriesFragment, title);
                } else {
                    activity.switchFragment(mDailyStoriesFragment, "首页");
                }
                getActivity().onBackPressed();
            }

            @Override
            public void onFollowClick() {
                Toast.makeText(getContext(),"关注成功，关注内容将在首页呈现",Toast.LENGTH_SHORT).show();
            }
        });
        init();
    }

    private void init() {
        navView.setLayoutManager(new LinearLayoutManager(getContext()));
        navView.setItemAnimator(new DefaultItemAnimator());
        navView.setAdapter(mAdapter);
        mPresenter.getThemesList();
    }

    @Override
    public void onDestroy() {
        mPresenter.unSubscription();
        mList.clear();
        super.onDestroy();
    }

    public ThemesListAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onRequestError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadThemeList(Themes themes) {
        mList.add(new DrawerHeader());
        mList.add(new DrawerHome());
        mList.addAll(themes.getOthers());
        mAdapter.notifyDataSetChanged();
    }

}
