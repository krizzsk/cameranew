package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqo implements Runnable {
    private final /* synthetic */ zzht zzajm;
    private final /* synthetic */ zzqj zzbna;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqo(zzqj zzqjVar, zzht zzhtVar) {
        this.zzbna = zzqjVar;
        this.zzajm = zzhtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzk(this.zzajm);
    }
}
