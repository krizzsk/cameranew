package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdct implements zzdfj<Bundle> {
    private final String zzdvs;
    private final String zzhbw;
    private final Bundle zzhbx;

    private zzdct(String str, String str2, Bundle bundle) {
        this.zzdvs = str;
        this.zzhbw = str2;
        this.zzhbx = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdvs);
        bundle2.putString("fc_consent", this.zzhbw);
        bundle2.putBundle("iab_consent_info", this.zzhbx);
    }
}
