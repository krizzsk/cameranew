package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdec implements zzdfj<Bundle> {
    private final Bundle zzfyw;

    public zzdec(Bundle bundle) {
        this.zzfyw = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle bundle3 = this.zzfyw;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
    }
}
