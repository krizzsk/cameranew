package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.facebook.ads.redexgen.X.CA;
@TargetApi(16)
/* loaded from: assets/audience_network.dex */
public interface C9<T extends CA> {
    C8<T> A2P(Looper looper, DrmInitData drmInitData);

    boolean A3v(DrmInitData drmInitData);

    void ADY(C8<T> c8);
}
