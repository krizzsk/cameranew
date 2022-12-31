package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
@TargetApi(16)
/* loaded from: assets/audience_network.dex */
public final class WT implements CA {
    public final MediaCrypto A00;
    public final boolean A01;

    public final MediaCrypto A00() {
        return this.A00;
    }

    public final boolean A01(String str) {
        return !this.A01 && this.A00.requiresSecureDecoderComponent(str);
    }
}
