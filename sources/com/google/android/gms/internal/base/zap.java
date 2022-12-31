package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class zap extends Handler {
    private static zar zash;

    public zap() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public zap(Looper looper) {
        super(looper);
    }

    public zap(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
