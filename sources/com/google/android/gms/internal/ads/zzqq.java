package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqq implements Runnable {
    private final /* synthetic */ zzqj zzbna;
    private final /* synthetic */ int zzbne;
    private final /* synthetic */ int zzbnf;
    private final /* synthetic */ int zzbng;
    private final /* synthetic */ float zzbnh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqq(zzqj zzqjVar, int i2, int i3, int i4, float f2) {
        this.zzbna = zzqjVar;
        this.zzbne = i2;
        this.zzbnf = i3;
        this.zzbng = i4;
        this.zzbnh = f2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqk zzqkVar;
        zzqkVar = this.zzbna.zzbmz;
        zzqkVar.zzb(this.zzbne, this.zzbnf, this.zzbng, this.zzbnh);
    }
}
