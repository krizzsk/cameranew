package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class HandlerC0769Bz extends Handler {
    public final /* synthetic */ WV A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bz != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T>$MediaDrmHandler */
    public HandlerC0769Bz(WV wv, Looper looper) {
        super(looper);
        this.A00 = wv;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bz != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSessionManager<T>$MediaDrmHandler */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WW != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T> */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        List<WW> list;
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            byte[] bArr = (byte[]) message.obj;
            list = this.A00.A09;
            for (WW ww : list) {
                if (ww.A0N(bArr)) {
                    ww.A0J(message.what);
                    return;
                }
            }
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
