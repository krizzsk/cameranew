package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddd implements zzdfj<Bundle> {
    private final Boolean zzhcc;

    public zzddd(Boolean bool) {
        this.zzhcc = bool;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Boolean bool = this.zzhcc;
        if (bool != null) {
            bundle2.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
