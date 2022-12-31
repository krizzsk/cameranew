package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbe implements zzdfj<Bundle> {
    private final Bundle zzhaw;

    private zzdbe(Bundle bundle) {
        this.zzhaw = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (this.zzhaw.isEmpty()) {
            return;
        }
        bundle2.putBundle("installed_adapter_data", this.zzhaw);
    }
}
