package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdel implements zzdfj<Bundle> {
    private final String zzhcp;

    public zzdel(String str) {
        this.zzhcp = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putString("rtb", this.zzhcp);
    }
}
