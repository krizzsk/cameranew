package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.drm.ExoMediaDrm;
@SuppressLint({"HandlerLeak"})
/* renamed from: com.facebook.ads.redexgen.X.Bo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class HandlerC0758Bo extends Handler {
    public final /* synthetic */ WW A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bo != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    public HandlerC0758Bo(WW ww, Looper looper) {
        super(looper);
        this.A00 = ww;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bo != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    private long A00(int i2) {
        return Math.min((i2 - 1) * 1000, 5000);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bo != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    private boolean A01(Message message) {
        int i2;
        if (message.arg1 == 1) {
            int i3 = message.arg2 + 1;
            i2 = this.A00.A0D;
            if (i3 > i2) {
                return false;
            }
            Message obtain = Message.obtain(message);
            obtain.arg2 = i3;
            sendMessageDelayed(obtain, A00(i3));
            return true;
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bo != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    public final void A02(int errorCount, Object obj, boolean z) {
        obtainMessage(errorCount, z ? 1 : 0, 0, obj).sendToTarget();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bo != com.facebook.ads.internal.exoplayer2.drm.DefaultDrmSession<T>$PostRequestHandler */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            Object obj = message.obj;
            try {
                int i2 = message.what;
                if (i2 == 0) {
                    e = this.A00.A0B.executeProvisionRequest(this.A00.A0C, (CF) obj);
                } else if (i2 == 1) {
                    Pair<ExoMediaDrm.KeyRequest, String> keyRequest = (Pair) obj;
                    e = this.A00.A0B.executeKeyRequest(this.A00.A0C, (CB) keyRequest.first, (String) keyRequest.second);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e2) {
                e = e2;
                if (A01(message)) {
                    return;
                }
            }
            this.A00.A0A.obtainMessage(message.what, Pair.create(obj, e)).sendToTarget();
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
