package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* renamed from: com.facebook.ads.redexgen.X.Oc  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class View$OnTouchListenerC1063Oc implements View.OnTouchListener {
    public final /* synthetic */ C06999f A00;

    public View$OnTouchListenerC1063Oc(C06999f c06999f) {
        this.A00 = c06999f;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        C1066Oh c1066Oh;
        c1066Oh = this.A00.A0E;
        c1066Oh.dispatchTouchEvent(MotionEvent.obtain(motionEvent));
        return false;
    }
}
