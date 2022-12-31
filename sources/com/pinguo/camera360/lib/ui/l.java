package com.pinguo.camera360.lib.ui;

import android.view.MotionEvent;
import android.view.View;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements View.OnTouchListener {
    public static final /* synthetic */ l a = new l();

    private /* synthetic */ l() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return WebViewActivity.q1(view, motionEvent);
    }
}
