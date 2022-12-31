package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzasn extends zzaxw {
    private final /* synthetic */ QueryInfoGenerationCallback zzdtq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasn(zzask zzaskVar, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdtq = queryInfoGenerationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void onError(String str) {
        this.zzdtq.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzx(str, bundle));
        zzwr.zzqv().put(queryInfo, str2);
        this.zzdtq.onSuccess(queryInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zzj(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzx(str, null));
        zzwr.zzqv().put(queryInfo, str2);
        this.zzdtq.onSuccess(queryInfo);
    }
}
