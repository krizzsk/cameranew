package com.google.android.gms.ads.internal.util;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class y implements Runnable {
    private final /* synthetic */ Context a;
    private final /* synthetic */ zzj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(zzj zzjVar, Context context) {
        this.b = zzjVar;
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.b.f3495d;
        synchronized (obj) {
            this.b.f3496e = zzj.i(this.a);
            obj2 = this.b.f3495d;
            obj2.notifyAll();
        }
    }
}
