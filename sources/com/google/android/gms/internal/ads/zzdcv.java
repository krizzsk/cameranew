package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcv implements zzdfj<Bundle> {
    private final Bundle zzhby;

    public zzdcv(Bundle bundle) {
        this.zzhby = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putBundle("content_info", this.zzhby);
    }
}
