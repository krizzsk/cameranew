package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztb implements zzrm {
    private final /* synthetic */ zzsz zzbvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztb(zzsz zzszVar) {
        this.zzbvc = zzszVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final void zzp(boolean z) {
        if (z) {
            this.zzbvc.connect();
        } else {
            this.zzbvc.disconnect();
        }
    }
}
