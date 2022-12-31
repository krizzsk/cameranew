package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes2.dex */
public abstract class PullToRequestListAdapter extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableListView listView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    public PullToRequestListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        ScrollableListView onNewListView = onNewListView(getContext());
        this.listView = onNewListView;
        onNewListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.mob.tools.gui.PullToRequestListAdapter.1
            private int firstVisibleItem;
            private int visibleItemCount;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                this.firstVisibleItem = i2;
                this.visibleItemCount = i3;
                View childAt = absListView.getChildAt(i3 - 1);
                PullToRequestListAdapter.this.pullUpReady = i2 + i3 == i4 && childAt != null && childAt.getBottom() <= absListView.getBottom();
                PullToRequestListAdapter pullToRequestListAdapter = PullToRequestListAdapter.this;
                pullToRequestListAdapter.onScroll(pullToRequestListAdapter.listView, i2, i3, i4);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                PullToRequestListAdapter.this.fling = i2 == 2;
                if (i2 == 0) {
                    if (PullToRequestListAdapter.this.osListener != null) {
                        PullToRequestListAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
                    } else if (PullToRequestListAdapter.this.adapter != null) {
                        PullToRequestListAdapter.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        PullToRequestBaseAdapter pullToRequestBaseAdapter = new PullToRequestBaseAdapter(this);
        this.adapter = pullToRequestBaseAdapter;
        this.listView.setAdapter((ListAdapter) pullToRequestBaseAdapter);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public Scrollable getBodyView() {
        return this.listView;
    }

    public ListView getListView() {
        return this.listView;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public boolean isFling() {
        return this.fling;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullDownReady() {
        return this.listView.isReadyToPull();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    protected ScrollableListView onNewListView(Context context) {
        return new ScrollableListView(context);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public void onScroll(Scrollable scrollable, int i2, int i3, int i4) {
    }

    public void setDivider(Drawable drawable) {
        this.listView.setDivider(drawable);
    }

    public void setDividerHeight(int i2) {
        this.listView.setDividerHeight(i2);
    }
}
