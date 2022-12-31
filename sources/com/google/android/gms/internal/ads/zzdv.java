package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdv implements Runnable {
    private final /* synthetic */ zzdw zzwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdv(zzdw zzdwVar) {
        this.zzwb = zzdwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConditionVariable conditionVariable;
        boolean z;
        zzfc zzfcVar;
        ConditionVariable conditionVariable2;
        if (this.zzwb.zzwf != null) {
            return;
        }
        conditionVariable = zzdw.zzwd;
        synchronized (conditionVariable) {
            if (this.zzwb.zzwf != null) {
                return;
            }
            boolean z2 = false;
            try {
                z = zzabp.zzcrw.get().booleanValue();
            } catch (IllegalStateException unused) {
                z = false;
            }
            if (z) {
                try {
                    zzfcVar = this.zzwb.zzwc;
                    zzdw.zzwe = new zztz(zzfcVar.context, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z2 = z;
            this.zzwb.zzwf = Boolean.valueOf(z2);
            conditionVariable2 = zzdw.zzwd;
            conditionVariable2.open();
        }
    }
}
