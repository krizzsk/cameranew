package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbdb implements Runnable {
    private final /* synthetic */ zzbdc zzepl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdb(zzbdc zzbdcVar) {
        this.zzepl = zzbdcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.zzr.zzln().zzb(this.zzepl);
    }
}
