package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdcz implements zzdfj<Bundle> {
    private final String zzdvc;
    private final boolean zzdve;

    public zzdcz(String str, boolean z) {
        this.zzdvc = str;
        this.zzdve = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("gct", this.zzdvc);
        if (this.zzdve) {
            bundle2.putString("de", "1");
        }
    }
}
