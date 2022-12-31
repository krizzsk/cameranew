package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
/* loaded from: assets/audience_network.dex */
public class PO implements View.OnTouchListener {
    public final /* synthetic */ PP A00;

    public PO(PP pp) {
        this.A00 = pp;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        JT jt;
        AnonymousClass16 anonymousClass16;
        if (motionEvent.getAction() == 1) {
            this.A00.A01 = System.currentTimeMillis();
            PP.A00(this.A00);
            jt = this.A00.A06;
            anonymousClass16 = this.A00.A03;
            jt.A90(anonymousClass16.A0Q(), new C1055Nu().A03(this.A00.getViewabilityChecker()).A02(this.A00.getTouchDataRecorder()).A05());
            return false;
        }
        return false;
    }
}
