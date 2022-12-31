package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bp  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class HandlerC0759Bp extends Handler {
    public final /* synthetic */ WW A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bp != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostResponseHandler */
    public HandlerC0759Bp(WW ww, Looper looper) {
        super(looper);
        this.A00 = ww;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bp != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostResponseHandler */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                this.A00.A0A(obj, obj2);
                return;
            }
            this.A00.A0B(obj, obj2);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
