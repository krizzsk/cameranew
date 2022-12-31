package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcth implements Runnable {
    private final zzcig zzgtf;

    private zzcth(zzcig zzcigVar) {
        this.zzgtf = zzcigVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzcig zzcigVar) {
        return new zzcth(zzcigVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgtf.zzapr();
    }
}
