package com.lcb.pubinfo.zhihudeabvo.ui.adapter.commeny;


import com.lcb.pubinfo.zhihudeabvo.bean.BaseItem;

/**
 * Created by OO on 2017/3/4.
 */

public class CommentSection implements BaseItem {
    private final int commentNumber;
    private final int type;
    public static final int LONG_COMMENT = 0;
    public static final int SHORT_COMMENT = 1;

    public CommentSection(int commentNumber, int commentType) {
        this.commentNumber = commentNumber;
        this.type = commentType;
    }

    public String getTitle() {
        if (type == LONG_COMMENT) {
            return commentNumber + "条长评";
        } else if (type == SHORT_COMMENT) {
            return commentNumber + "条短评";
        }
        return "";
    }

    public int getType() {
        return type;
    }
}
