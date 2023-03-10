package com.google.android.gms.internal.ads;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddl implements zzdfj<Bundle> {
    private final zzdmu zzfrb;

    public zzddl(zzdmu zzdmuVar) {
        this.zzfrb = zzdmuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdmu zzdmuVar = this.zzfrb;
        if (zzdmuVar != null) {
            bundle2.putBoolean("render_in_browser", zzdmuVar.zzaux());
            bundle2.putBoolean("disable_ml", this.zzfrb.zzauy());
        }
    }
}
