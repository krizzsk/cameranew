package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzuq;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(26)
/* loaded from: classes2.dex */
public class zzz extends zzaa {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public final zzuq zza(Context context, TelephonyManager telephonyManager) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        if (zzj.zzp(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzuq.ENUM_TRUE : zzuq.ENUM_FALSE;
        }
        return zzuq.ENUM_FALSE;
    }
}
