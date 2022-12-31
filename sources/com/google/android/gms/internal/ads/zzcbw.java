package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcbw implements Runnable {
    private final zzccl zzgdu;

    private zzcbw(zzccl zzcclVar) {
        this.zzgdu = zzcclVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzccl zzcclVar) {
        return new zzcbw(zzcclVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgdu.zzanl();
    }
}
