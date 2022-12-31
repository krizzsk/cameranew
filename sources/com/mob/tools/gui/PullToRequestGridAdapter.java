package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes2.dex */
public abstract class PullToRequestGridAdapter extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableGridView gridView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    public PullToRequestGridAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        ScrollableGridView onNewGridView = onNewGridView(getContext());
        this.gridView = onNewGridView;
        onNewGridView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.mob.tools.gui.PullToRequestGridAdapter.1
            private int firstVisibleItem;
            private int visibleItemCount;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                this.firstVisibleItem = i2;
                this.visibleItemCount = i3;
                View childAt = absListView.getChildAt(i3 - 1);
                PullToRequestGridAdapter.this.pullUpReady = i2 + i3 == i4 && childAt != null && childAt.getBottom() <= absListView.getBottom();
                PullToRequestGridAdapter pullToRequestGridAdapter = PullToRequestGridAdapter.this;
                pullToRequestGridAdapter.onScroll(pullToRequestGridAdapter.gridView, i2, i3, i4);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                PullToRequestGridAdapter.this.fling = i2 == 2;
                if (i2 == 0) {
                    if (PullToRequestGridAdapter.this.osListener != null) {
                        PullToRequestGridAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
                    } else if (PullToRequestGridAdapter.this.adapter != null) {
                        PullToRequestGridAdapter.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        PullToRequestBaseAdapter pullToRequestBaseAdapter = new PullToRequestBaseAdapter(this);
        this.adapter = pullToRequestBaseAdapter;
        this.gridView.setAdapter((ListAdapter) pullToRequestBaseAdapter);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public Scrollable getBodyView() {
        return this.gridView;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public boolean isFling() {
        return this.fling;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullDownReady() {
        return this.gridView.isReadyToPull();
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

    protected ScrollableGridView onNewGridView(Context context) {
        return new ScrollableGridView(context);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public void onScroll(Scrollable scrollable, int i2, int i3, int i4) {
    }

    public void setColumnWidth(int i2) {
        this.gridView.setColumnWidth(i2);
    }

    public void setHorizontalSpacing(int i2) {
        this.gridView.setHorizontalSpacing(i2);
    }

    public void setNumColumns(int i2) {
        this.gridView.setNumColumns(i2);
    }

    public void setStretchMode(int i2) {
        this.gridView.setStretchMode(i2);
    }

    public void setVerticalSpacing(int i2) {
        this.gridView.setVerticalSpacing(i2);
    }
}
