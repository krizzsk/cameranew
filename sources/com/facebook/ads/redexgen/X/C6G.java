package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
/* renamed from: com.facebook.ads.redexgen.X.6G  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C6G extends Handler {
    public final /* synthetic */ C6H A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6G(C6H c6h, Looper looper) {
        super(looper);
        this.A00 = c6h;
    }

    @Override // android.os.Handler
    @SuppressLint({"CatchGeneralException"})
    public final void handleMessage(Message message) {
        MotionEvent motionEvent;
        C6R c6r;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            if (C6E.A00[C6F.values()[message.what].ordinal()] == 1 && (motionEvent = (MotionEvent) message.obj) != null) {
                c6r = this.A00.A02;
                c6r.A00(motionEvent);
            }
        } catch (Throwable th) {
            try {
                C6D.A03(th);
            } catch (Throwable th2) {
                C0974Kn.A00(th2, this);
            }
        }
    }
}
