package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddh implements zzdfj<Bundle> {
    private final Bundle zzdvb;

    public zzddh(Bundle bundle) {
        this.zzdvb = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle zza = zzdnz.zza(bundle2, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX);
        zza.putBundle("android_mem_info", this.zzdvb);
        bundle2.putBundle(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, zza);
    }
}
