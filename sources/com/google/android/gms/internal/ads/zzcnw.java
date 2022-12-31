package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzcnw implements zzbua {
    private final Context context;
    private final zzaxc zzbqv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnw(Context context, zzaxc zzaxcVar) {
        this.context = context;
        this.zzbqv = zzaxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzb(zzdnl zzdnlVar) {
        if (TextUtils.isEmpty(zzdnlVar.zzhks.zzess.zzdwy)) {
            return;
        }
        this.zzbqv.zza(this.context, zzdnlVar.zzhkr.zzfwy.zzhkw);
        this.zzbqv.zzi(this.context, zzdnlVar.zzhks.zzess.zzdwy);
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void zzd(zzatq zzatqVar) {
    }
}
