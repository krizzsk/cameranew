package com.pinguo.album;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: SynchronizedHandler.java */
/* loaded from: classes3.dex */
public class g extends Handler {
    private final WeakReference<com.pinguo.album.views.b> a;

    public g(com.pinguo.album.views.b bVar) {
        com.pinguo.album.j.a.c(bVar);
        this.a = new WeakReference<>(bVar);
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        com.pinguo.album.views.b bVar = this.a.get();
        if (bVar == null) {
            return;
        }
        bVar.c();
        try {
            super.dispatchMessage(message);
        } finally {
            bVar.g();
        }
    }
}
