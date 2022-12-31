package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbbc implements Runnable {
    private final /* synthetic */ zzbax zzekp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbc(zzbax zzbaxVar) {
        this.zzekp = zzbaxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzekp.zzd("surfaceCreated", new String[0]);
    }
}
