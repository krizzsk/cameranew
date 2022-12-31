package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztd implements c.b {
    private final /* synthetic */ zzsz zzbvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztd(zzsz zzszVar) {
        this.zzbvc = zzszVar;
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Object obj;
        zzte zzteVar;
        Object obj2;
        obj = this.zzbvc.lock;
        synchronized (obj) {
            this.zzbvc.zzbvf = null;
            zzteVar = this.zzbvc.zzbve;
            if (zzteVar != null) {
                this.zzbvc.zzbve = null;
            }
            obj2 = this.zzbvc.lock;
            obj2.notifyAll();
        }
    }
}
