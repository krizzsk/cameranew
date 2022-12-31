package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzche implements Runnable {
    private final zzbeb zzeuk;

    private zzche(zzbeb zzbebVar) {
        this.zzeuk = zzbebVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zze(zzbeb zzbebVar) {
        return new zzche(zzbebVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeuk.destroy();
    }
}
