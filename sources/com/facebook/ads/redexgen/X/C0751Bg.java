package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
@TargetApi(24)
/* renamed from: com.facebook.ads.redexgen.X.Bg  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0751Bg {
    public final MediaCodec.CryptoInfo.Pattern A00;
    public final MediaCodec.CryptoInfo A01;

    public C0751Bg(MediaCodec.CryptoInfo cryptoInfo) {
        this.A01 = cryptoInfo;
        this.A00 = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00(int i2, int i3) {
        this.A00.set(i2, i3);
        this.A01.setPattern(this.A00);
    }
}
