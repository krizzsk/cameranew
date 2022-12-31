package com.unity3d.splash.services.ads.adunit;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AdUnitRelativeLayout extends RelativeLayout {
    private final ArrayList a;
    private int b;
    private boolean c;

    public AdUnitRelativeLayout(Context context) {
        super(context);
        this.a = new ArrayList();
        this.b = 10000;
        this.c = false;
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onInterceptTouchEvent(motionEvent);
        if (!this.c || this.a.size() >= this.b) {
            return false;
        }
        boolean z = (motionEvent.getFlags() & 1) != 0;
        synchronized (this.a) {
            this.a.add(new a(motionEvent.getActionMasked(), z, motionEvent.getToolType(0), motionEvent.getSource(), motionEvent.getDeviceId(), motionEvent.getX(0), motionEvent.getY(0), motionEvent.getEventTime(), motionEvent.getPressure(0), motionEvent.getSize(0)));
        }
        return false;
    }
}
