package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzbba implements Runnable {
    private final zzbav zzeko;

    private zzbba(zzbav zzbavVar) {
        this.zzeko = zzbavVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zza(zzbav zzbavVar) {
        return new zzbba(zzbavVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzeko.stop();
    }
}
