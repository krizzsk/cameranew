package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzasp extends zzasi {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzdts;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzasp(zzasm zzasmVar, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzdts = updateImpressionUrlsCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void onError(String str) {
        this.zzdts.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void onSuccess(List<Uri> list) {
        this.zzdts.onSuccess(list);
    }
}
