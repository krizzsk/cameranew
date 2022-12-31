package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzta implements c.a {
    private final /* synthetic */ zzsz zzbvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzta(zzsz zzszVar) {
        this.zzbvc = zzszVar;
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnected(@Nullable Bundle bundle) {
        Object obj;
        Object obj2;
        zzte zzteVar;
        zzte zzteVar2;
        obj = this.zzbvc.lock;
        synchronized (obj) {
            try {
                zzteVar = this.zzbvc.zzbve;
                if (zzteVar != null) {
                    zzsz zzszVar = this.zzbvc;
                    zzteVar2 = zzszVar.zzbve;
                    zzszVar.zzbvf = zzteVar2.zznd();
                }
            } catch (DeadObjectException e2) {
                zzazk.zzc("Unable to obtain a cache service instance.", e2);
                this.zzbvc.disconnect();
            }
            obj2 = this.zzbvc.lock;
            obj2.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void onConnectionSuspended(int i2) {
        Object obj;
        Object obj2;
        obj = this.zzbvc.lock;
        synchronized (obj) {
            this.zzbvc.zzbvf = null;
            obj2 = this.zzbvc.lock;
            obj2.notifyAll();
        }
    }
}
