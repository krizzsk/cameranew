package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
/* renamed from: com.facebook.ads.redexgen.X.79  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class AnonymousClass79 {
    public Handler A00;

    public AnonymousClass79(Looper looper) {
        this.A00 = new Handler(looper);
    }

    public final void A00(C7A c7a) {
        this.A00.post(c7a);
    }

    public final void A01(C7A c7a) {
        this.A00.removeCallbacks(c7a);
    }

    public final boolean A02(C7A c7a, long j2) {
        return this.A00.postDelayed(c7a, j2);
    }
}
