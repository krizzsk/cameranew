package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdby implements zzdfj<Bundle> {
    private final double zzdyh;
    private final boolean zzdyi;

    public zzdby(double d2, boolean z) {
        this.zzdyh = d2;
        this.zzdyi = z;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdnz.zza(bundle2, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        bundle2.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
        Bundle zza2 = zzdnz.zza(zza, "battery");
        zza.putBundle("battery", zza2);
        zza2.putBoolean("is_charging", this.zzdyi);
        zza2.putDouble("battery_level", this.zzdyh);
    }
}
