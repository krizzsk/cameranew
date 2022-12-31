package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: WeakHandler.java */
/* loaded from: classes.dex */
public class ad extends Handler {
    private final WeakReference<a> a;

    /* compiled from: WeakHandler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Message message);
    }

    public ad(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }

    public ad(Looper looper, a aVar) {
        super(looper);
        this.a = new WeakReference<>(aVar);
    }
}
