package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
/* loaded from: classes2.dex */
public abstract class PullToRequestAdatper {
    private Context context;
    private PullToRequestView parent;

    public PullToRequestAdatper(PullToRequestView pullToRequestView) {
        this.context = pullToRequestView.getContext();
        this.parent = pullToRequestView;
    }

    public abstract Scrollable getBodyView();

    public Context getContext() {
        return this.context;
    }

    public abstract View getFooterView();

    public abstract View getHeaderView();

    protected PullToRequestView getParent() {
        return this.parent;
    }

    public abstract boolean isPullDownReady();

    public abstract boolean isPullUpReady();

    public void notifyDataSetChanged() {
        this.parent.stopPulling();
    }

    public void onPullDown(int i2) {
    }

    public void onPullUp(int i2) {
    }

    public void onRefresh() {
    }

    public void onRequestNext() {
    }

    public void onReversed() {
    }
}
