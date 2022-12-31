package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzdjj implements Runnable {
    private final zzcxy zzgyy;

    private zzdjj(zzcxy zzcxyVar) {
        this.zzgyy = zzcxyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzcxy zzcxyVar) {
        return new zzdjj(zzcxyVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzgyy.onAdLoaded();
    }
}
