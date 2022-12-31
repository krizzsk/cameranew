package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Pb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC1086Pb implements View.OnTouchListener {
    public final /* synthetic */ C1099Po A00;

    public View$OnTouchListenerC1086Pb(C1099Po c1099Po) {
        this.A00 = c1099Po;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C9O c9o;
        c9o = this.A00.A0A;
        c9o.A02(new KP(view, motionEvent));
        return false;
    }
}
