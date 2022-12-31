package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdmg implements Runnable {
    private final zzdlh zzhil;

    private zzdmg(zzdlh zzdlhVar) {
        this.zzhil = zzdlhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzdlh zzdlhVar) {
        return new zzdmg(zzdlhVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzhil.onAdLoaded();
    }
}
