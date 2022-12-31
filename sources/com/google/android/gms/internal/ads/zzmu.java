package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmu implements Runnable {
    private final /* synthetic */ zzms zzbdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmu(zzms zzmsVar) {
        this.zzbdl = zzmsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zznb zznbVar;
        z = this.zzbdl.zzafw;
        if (z) {
            return;
        }
        zznbVar = this.zzbdl.zzbdy;
        zznbVar.zza((zznb) this.zzbdl);
    }
}
