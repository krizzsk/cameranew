package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdeg implements zzdfj<Bundle> {
    private String zzdun;

    public zzdeg(String str) {
        this.zzdun = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        bundle.putString("request_id", this.zzdun);
    }
}
