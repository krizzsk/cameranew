package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/* loaded from: classes2.dex */
public class PullToRequestBaseAdapter extends BaseAdapter {
    private PullToRequestBaseListAdapter adapter;

    public PullToRequestBaseAdapter(PullToRequestBaseListAdapter pullToRequestBaseListAdapter) {
        this.adapter = pullToRequestBaseListAdapter;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.adapter.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.adapter.getItem(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return this.adapter.getItemId(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return this.adapter.getItemViewType(i2);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        return this.adapter.getView(i2, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.adapter.getViewTypeCount();
    }
}
