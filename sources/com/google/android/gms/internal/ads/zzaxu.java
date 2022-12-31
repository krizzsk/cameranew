package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaxu {
    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            return Uri.parse(str.substring(0, i2) + str2 + "=" + str3 + "&" + str.substring(i2));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }

    private static String zzb(String str, Context context) {
        String zzab = com.google.android.gms.ads.internal.zzr.zzlp().zzab(context);
        String zzac = com.google.android.gms.ads.internal.zzr.zzlp().zzac(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzab)) {
            str = zza(str, "gmp_app_id", zzab).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzac)) ? str : zza(str, "fbs_aiid", zzac).toString();
    }

    public static String zzc(String str, Context context, boolean z) {
        String zzad;
        if ((!((Boolean) zzwr.zzqr().zzd(zzabp.zzcoo)).booleanValue() || z) && com.google.android.gms.ads.internal.zzr.zzlp().zzy(context) && !TextUtils.isEmpty(str) && (zzad = com.google.android.gms.ads.internal.zzr.zzlp().zzad(context)) != null) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcog)).booleanValue()) {
                String str2 = (String) zzwr.zzqr().zzd(zzabp.zzcoh);
                if (str.contains(str2)) {
                    if (com.google.android.gms.ads.internal.zzr.zzkr().zzei(str)) {
                        com.google.android.gms.ads.internal.zzr.zzlp().zzg(context, zzad);
                        return zzb(str, context).replace(str2, zzad);
                    } else if (com.google.android.gms.ads.internal.zzr.zzkr().zzej(str)) {
                        com.google.android.gms.ads.internal.zzr.zzlp().zzh(context, zzad);
                        return zzb(str, context).replace(str2, zzad);
                    } else {
                        return str;
                    }
                }
                return str;
            } else if (str.contains("fbs_aeid")) {
                return str;
            } else {
                if (com.google.android.gms.ads.internal.zzr.zzkr().zzei(str)) {
                    com.google.android.gms.ads.internal.zzr.zzlp().zzg(context, zzad);
                    return zza(zzb(str, context), "fbs_aeid", zzad).toString();
                } else if (com.google.android.gms.ads.internal.zzr.zzkr().zzej(str)) {
                    com.google.android.gms.ads.internal.zzr.zzlp().zzh(context, zzad);
                    return zza(zzb(str, context), "fbs_aeid", zzad).toString();
                } else {
                    return str;
                }
            }
        }
        return str;
    }

    public static String zzb(Uri uri, Context context) {
        if (!com.google.android.gms.ads.internal.zzr.zzlp().zzy(context)) {
            return uri.toString();
        }
        String zzad = com.google.android.gms.ads.internal.zzr.zzlp().zzad(context);
        if (zzad == null) {
            return uri.toString();
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcog)).booleanValue()) {
            String str = (String) zzwr.zzqr().zzd(zzabp.zzcoh);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                com.google.android.gms.ads.internal.zzr.zzlp().zzg(context, zzad);
                return zzb(uri2, context).replace(str, zzad);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = zza(zzb(uri.toString(), context), "fbs_aeid", zzad).toString();
            com.google.android.gms.ads.internal.zzr.zzlp().zzg(context, zzad);
            return uri3;
        }
        return uri.toString();
    }
}
