package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztm extends zzbaa<zztv> {
    private final /* synthetic */ zztn zzbvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztm(zztn zztnVar) {
        this.zzbvu = zztnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbaa, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbvu.disconnect();
        return super.cancel(z);
    }
}
