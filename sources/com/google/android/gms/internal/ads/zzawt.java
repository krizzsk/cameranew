package com.google.android.gms.internal.ads;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzawt implements zzdzl<Void> {
    private final /* synthetic */ zzdzw zzeal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawt(zzawm zzawmVar, zzdzw zzdzwVar) {
        this.zzeal = zzdzwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final /* synthetic */ void onSuccess(Void r2) {
        List list;
        list = zzawm.zzdzv;
        list.remove(this.zzeal);
    }

    @Override // com.google.android.gms.internal.ads.zzdzl
    public final void zzb(Throwable th) {
        List list;
        list = zzawm.zzdzv;
        list.remove(this.zzeal);
    }
}
