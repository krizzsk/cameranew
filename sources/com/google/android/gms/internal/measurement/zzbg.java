package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzbg implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzbr zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(zzbr zzbrVar, boolean z) {
        this.zzk = zzbrVar;
        this.zzh = zzbrVar.zza.currentTimeMillis();
        this.zzi = zzbrVar.zza.a();
        this.zzj = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        z = this.zzk.zzi;
        if (z) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e2) {
            this.zzk.zzV(e2, false, this.zzj);
            zzb();
        }
    }

    abstract void zza() throws RemoteException;

    protected void zzb() {
    }
}
