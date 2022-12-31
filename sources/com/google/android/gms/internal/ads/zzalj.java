package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzalj implements Runnable {
    private final zzakm zzdjx;

    private zzalj(zzakm zzakmVar) {
        this.zzdjx = zzakmVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable zzb(zzakm zzakmVar) {
        return new zzalj(zzakmVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzdjx.destroy();
    }
}
