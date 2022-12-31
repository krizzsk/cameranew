package com.google.android.gms.internal.ads;

import android.os.Looper;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbbk implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbk(zzbbh zzbbhVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
