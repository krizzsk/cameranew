package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(23)
/* loaded from: classes2.dex */
final class zzqf implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzqe zzbmh;

    private zzqf(zzqe zzqeVar, MediaCodec mediaCodec) {
        this.zzbmh = zzqeVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j2, long j3) {
        zzqe zzqeVar = this.zzbmh;
        if (this != zzqeVar.zzbme) {
            return;
        }
        zzqeVar.zzjk();
    }
}
