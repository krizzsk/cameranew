package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamm implements zzbac {
    private final /* synthetic */ zzbaa zzdik;
    private final /* synthetic */ zzalm zzdlb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamm(zzamk zzamkVar, zzbaa zzbaaVar, zzalm zzalmVar) {
        this.zzdik = zzbaaVar;
        this.zzdlb = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbac
    public final void run() {
        this.zzdik.setException(new zzaly("Unable to obtain a JavascriptEngine."));
        this.zzdlb.release();
    }
}
