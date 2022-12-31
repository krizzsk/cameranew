package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public final class UG implements I9 {
    @Override // com.facebook.ads.redexgen.X.I9
    public final IJ A4H(Looper looper, @Nullable Handler.Callback callback) {
        return new UF(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.X.I9
    public final long A55() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.X.I9
    public final long AFA() {
        return SystemClock.uptimeMillis();
    }
}
