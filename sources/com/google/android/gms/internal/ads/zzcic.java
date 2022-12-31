package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcic implements zzaqt {
    private final /* synthetic */ zzchs zzgkd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcic(zzchs zzchsVar) {
        this.zzgkd = zzchsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzc(int i2, int i3, int i4, int i5) {
        zzbsm zzbsmVar;
        zzbsmVar = this.zzgkd.zzfwu;
        zzbsmVar.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzvq() {
        zzbsm zzbsmVar;
        zzbsmVar = this.zzgkd.zzfwu;
        zzbsmVar.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzvr() {
        zzbvi zzbviVar;
        zzbviVar = this.zzgkd.zzgka;
        zzbviVar.zzakf();
    }
}
