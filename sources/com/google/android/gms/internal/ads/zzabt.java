package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.tapjoy.TapjoyConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzabt {
    private Context context;
    private String zzbrp;
    private String zzdat = zzadf.zzddh.get();
    private Map<String, String> zzdaw;

    public zzabt(Context context, String str) {
        String packageName;
        this.context = null;
        this.zzbrp = null;
        this.context = context;
        this.zzbrp = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzdaw = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        this.zzdaw.put("v", "3");
        this.zzdaw.put("os", Build.VERSION.RELEASE);
        this.zzdaw.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzdaw;
        com.google.android.gms.ads.internal.zzr.zzkr();
        map.put(TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX, com.google.android.gms.ads.internal.util.zzj.zzyz());
        Map<String, String> map2 = this.zzdaw;
        if (context.getApplicationContext() != null) {
            packageName = context.getApplicationContext().getPackageName();
        } else {
            packageName = context.getPackageName();
        }
        map2.put("app", packageName);
        Map<String, String> map3 = this.zzdaw;
        com.google.android.gms.ads.internal.zzr.zzkr();
        map3.put("is_lite_sdk", com.google.android.gms.ads.internal.util.zzj.zzau(context) ? "1" : "0");
        Future<zzatz> zzv = com.google.android.gms.ads.internal.zzr.zzlc().zzv(this.context);
        try {
            this.zzdaw.put("network_coarse", Integer.toString(zzv.get().zzdyc));
            this.zzdaw.put("network_fine", Integer.toString(zzv.get().zzdyd));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzlw() {
        return this.zzbrp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzsj() {
        return this.zzdat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zzsk() {
        return this.zzdaw;
    }
}
