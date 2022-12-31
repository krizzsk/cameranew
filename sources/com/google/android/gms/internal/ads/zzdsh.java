package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tapjoy.TapjoyConstants;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsh {
    private final Context context;
    private final String packageName;
    private final String zzbrp;

    public zzdsh(Context context, zzazn zzaznVar) {
        this.context = context;
        this.packageName = context.getPackageName();
        this.zzbrp = zzaznVar.zzbrp;
    }

    public final void zzq(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzr.zzkr();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.google.android.gms.ads.internal.util.zzj.zzyz());
        map.put("app", this.packageName);
        com.google.android.gms.ads.internal.zzr.zzkr();
        map.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzj.zzau(this.context) ? "1" : "0");
        map.put("e", TextUtils.join(",", zzabp.zzsd()));
        map.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.zzbrp);
    }
}
