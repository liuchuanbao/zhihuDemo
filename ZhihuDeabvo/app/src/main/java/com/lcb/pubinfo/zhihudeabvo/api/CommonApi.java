package com.lcb.pubinfo.zhihudeabvo.api;


import com.lcb.pubinfo.zhihudeabvo.bean.BeforeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.BeforeThemeStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LatestStories;
import com.lcb.pubinfo.zhihudeabvo.bean.LaunchImage;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContent;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentExtra;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentLongComment;
import com.lcb.pubinfo.zhihudeabvo.bean.StoryContentShortComment;
import com.lcb.pubinfo.zhihudeabvo.bean.Themes;
import com.lcb.pubinfo.zhihudeabvo.bean.ThemesContent;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by pubinfo on 2017/3/27.
 */

public interface CommonApi {
    @GET("/api/4/news/latest")
    Observable<LatestStories> getLatestStories();

    @GET("/api/4/news/before/{date}")
    Observable<BeforeStories> getBeforeStories(@Path("date") String date);

    @GET("/api/4/news/{id}")
    Observable<StoryContent> getStoryContent(@Path("id") int id);

    @GET("/api/4/story-extra/{id}")
    Observable<StoryContentExtra> getStoryContentExtra(@Path("id") int id);
//
    @GET("/api/4/story/{id}/long-comments")
    Observable<StoryContentLongComment> getStoryContentLongComments(@Path("id") int id);

    @GET("/api/4/story/{id}/short-comments")
    Observable<StoryContentShortComment> getStoryContentShortComments(@Path("id") int id);

    @GET("/api/4/themes")
    Observable<Themes> getThemesList();

    @GET("/api/4/theme/{id}")
    Observable<ThemesContent> getThemesContent(@Path("id") int id);

    @GET("/api/4/theme/{id}/before/{story_id}")
    Observable<BeforeThemeStories> getBeforeThemesContent(@Path("id") int id, @Path("story_id") int story_id);

    @GET("/api/7/prefetch-launch-images/1080*1920")
    Observable<LaunchImage> getLaunchImage();

}
