package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzddu implements zzdfj<Bundle> {
    private final String zzhcj;

    public zzddu(String str) {
        this.zzhcj = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains(TapjoyConstants.TJC_PLUGIN_NATIVE) || set.contains("banner");
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        zzdnz.zza(bundle, "omid_v", this.zzhcj);
    }
}
