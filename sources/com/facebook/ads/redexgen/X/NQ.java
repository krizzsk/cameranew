package com.facebook.ads.redexgen.X;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class NQ implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        int action = motionEvent.getAction();
        if (action == 0) {
            i2 = NW.A0D;
            M5.A0M(view, i2);
        } else if (action == 1) {
            M5.A0M(view, 0);
        }
        return false;
    }
}
