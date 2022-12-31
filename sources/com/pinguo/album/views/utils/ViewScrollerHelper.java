package com.pinguo.album.views.utils;

import android.content.Context;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
/* loaded from: classes3.dex */
public class ViewScrollerHelper {
    public ViewScrollerHelper(Context context) {
        new OverScroller(context);
        ViewConfiguration.get(context).getScaledOverflingDistance();
    }
}
