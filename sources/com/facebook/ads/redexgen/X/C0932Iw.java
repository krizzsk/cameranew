package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;
@TargetApi(23)
/* renamed from: com.facebook.ads.redexgen.X.Iw  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0932Iw implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ C1W A00;

    public C0932Iw(C1W c1w, MediaCodec mediaCodec) {
        this.A00 = c1w;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
        if (this != this.A00.A00) {
            return;
        }
        this.A00.A1R();
    }
}
