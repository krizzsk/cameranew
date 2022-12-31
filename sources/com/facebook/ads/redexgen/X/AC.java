package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: assets/audience_network.dex */
public class AC extends Handler {
    public final /* synthetic */ DU A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AC(DU du, Looper looper) {
        super(looper);
        this.A00 = du;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (C0974Kn.A02(this)) {
            return;
        }
        try {
            this.A00.A0A(message);
        } catch (Throwable th) {
            C0974Kn.A00(th, this);
        }
    }
}
