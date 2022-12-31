package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdvy extends zzdvv {
    static final zzdvy zzhvt = new zzdvy();

    private zzdvy() {
        super("CharMatcher.none()");
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final int zza(CharSequence charSequence, int i2) {
        zzdwl.zzb(i2, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final boolean zzc(char c) {
        return false;
    }
}
