package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class zzdvl extends Handler {
    private static zzdvo zzhvf;

    public zzdvl() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void zzb(Message message) {
        super.dispatchMessage(message);
    }

    public zzdvl(Looper looper) {
        super(looper);
    }
}
