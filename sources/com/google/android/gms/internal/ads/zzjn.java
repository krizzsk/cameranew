package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(24)
/* loaded from: classes2.dex */
final class zzjn {
    private final MediaCodec.CryptoInfo zzany;
    private final MediaCodec.CryptoInfo.Pattern zzaoh;

    private zzjn(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzany = cryptoInfo;
        this.zzaoh = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set(int i2, int i3) {
        this.zzaoh.set(0, 0);
        this.zzany.setPattern(this.zzaoh);
    }
}
