package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.tencent.tauth.AuthActivity;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzahn implements zzaif<zzbeb> {
    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzbeb zzbebVar2 = zzbebVar;
        String str = (String) map.get(AuthActivity.ACTION_KEY);
        if ("tick".equals(str)) {
            String str2 = (String) map.get(Constants.ScionAnalytics.PARAM_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzazk.zzex("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzazk.zzex("No timestamp given for CSI tick.");
            } else {
                try {
                    long a = com.google.android.gms.ads.internal.zzr.zzky().a() + (Long.parseLong(str4) - com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis());
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbebVar2.zzabi().zzb(str2, str3, a);
                } catch (NumberFormatException e2) {
                    zzazk.zzd("Malformed timestamp for CSI tick.", e2);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get(FirebaseAnalytics.Param.VALUE);
            if (TextUtils.isEmpty(str5)) {
                zzazk.zzex("No value given for CSI experiment.");
                return;
            }
            zzacc zzsp = zzbebVar2.zzabi().zzsp();
            if (zzsp == null) {
                zzazk.zzex("No ticker for WebView, dropping experiment ID.");
            } else {
                zzsp.zzg("e", str5);
            }
        } else if (JsonMarshaller.EXTRA.equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get(FirebaseAnalytics.Param.VALUE);
            if (TextUtils.isEmpty(str7)) {
                zzazk.zzex("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzazk.zzex("No name given for CSI extra.");
            } else {
                zzacc zzsp2 = zzbebVar2.zzabi().zzsp();
                if (zzsp2 == null) {
                    zzazk.zzex("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzsp2.zzg(str6, str7);
                }
            }
        }
    }
}
