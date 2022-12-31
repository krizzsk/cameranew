package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbes implements Runnable {
    private final /* synthetic */ zzbeq zzetv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbes(zzbeq zzbeqVar) {
        this.zzetv = zzbeqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbeb zzbebVar;
        zzbebVar = this.zzetv.zzesi;
        zzbebVar.destroy();
    }
}
