package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdft implements zzdfj<Bundle> {
    private final String zzdyb;
    private final int zzdyc;
    private final int zzdyd;
    private final int zzdye;
    private final boolean zzdyf;
    private final int zzdyg;

    public zzdft(String str, int i2, int i3, int i4, boolean z, int i5) {
        this.zzdyb = str;
        this.zzdyc = i2;
        this.zzdyd = i3;
        this.zzdye = i4;
        this.zzdyf = z;
        this.zzdyg = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.zzdyb;
        zzdnz.zza(bundle2, "carrier", str, !TextUtils.isEmpty(str));
        zzdnz.zza(bundle2, "cnt", Integer.valueOf(this.zzdyc), this.zzdyc != -2);
        bundle2.putInt("gnt", this.zzdyd);
        bundle2.putInt("pt", this.zzdye);
        Bundle zza = zzdnz.zza(bundle2, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        bundle2.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
        Bundle zza2 = zzdnz.zza(zza, "network");
        zza.putBundle("network", zza2);
        zza2.putInt("active_network_state", this.zzdyg);
        zza2.putBoolean("active_network_metered", this.zzdyf);
    }
}
