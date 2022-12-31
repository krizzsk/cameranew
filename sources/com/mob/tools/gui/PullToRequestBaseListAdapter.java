package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public abstract class PullToRequestBaseListAdapter extends PullToRequestAdatper {
    public PullToRequestBaseListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
    }

    public abstract int getCount();

    public abstract Object getItem(int i2);

    public abstract long getItemId(int i2);

    public int getItemViewType(int i2) {
        return 0;
    }

    public abstract View getView(int i2, View view, ViewGroup viewGroup);

    public int getViewTypeCount() {
        return 1;
    }

    public abstract boolean isFling();

    public abstract void onScroll(Scrollable scrollable, int i2, int i3, int i4);
}
