package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzaso extends zzasi {
    private final /* synthetic */ UpdateClickUrlCallback zzdtr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaso(zzasm zzasmVar, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdtr = updateClickUrlCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void onError(String str) {
        this.zzdtr.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzasj
    public final void onSuccess(List<Uri> list) {
        this.zzdtr.onSuccess(list.get(0));
    }
}
