package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.tapjoy.TapjoyConstants;
import com.tencent.tauth.AuthActivity;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaio implements zzaif<Object> {
    private final zzair zzdim;

    private zzaio(zzair zzairVar) {
        this.zzdim = zzairVar;
    }

    public static void zza(zzbeb zzbebVar, zzair zzairVar) {
        zzbebVar.zza("/reward", new zzaio(zzairVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AuthActivity.ACTION_KEY);
        if ("grant".equals(str)) {
            zzavj zzavjVar = null;
            try {
                int parseInt = Integer.parseInt(map.get(TapjoyConstants.TJC_AMOUNT));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzavjVar = new zzavj(str2, parseInt);
                }
            } catch (NumberFormatException e2) {
                zzazk.zzd("Unable to parse reward amount.", e2);
            }
            this.zzdim.zza(zzavjVar);
        } else if ("video_start".equals(str)) {
            this.zzdim.zzuc();
        } else if ("video_complete".equals(str)) {
            this.zzdim.zzud();
        }
    }
}
