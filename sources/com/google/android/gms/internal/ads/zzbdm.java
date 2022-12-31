package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbdm implements zzaif<zzbbo> {
    private static Integer zza(Map<String, String> map, String str) {
        if (map.containsKey(str)) {
            try {
                return Integer.valueOf(Integer.parseInt(map.get(str)));
            } catch (NumberFormatException unused) {
                String str2 = map.get(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
                sb.append("Precache invalid numeric parameter '");
                sb.append(str);
                sb.append("': ");
                sb.append(str2);
                zzazk.zzex(sb.toString());
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final /* synthetic */ void zza(zzbbo zzbboVar, Map map) {
        zzbdd zzbddVar;
        zzbbo zzbboVar2 = zzbboVar;
        if (zzazk.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzazk.zzdy(sb.toString());
        }
        com.google.android.gms.ads.internal.zzr.zzln();
        if (map.containsKey("abort")) {
            if (zzbde.zzc(zzbboVar2)) {
                return;
            }
            zzazk.zzex("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer zza = zza(map, "periodicReportIntervalMs");
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        strArr2[i2] = jSONArray.getString(i2);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    String valueOf2 = String.valueOf(str2);
                    zzazk.zzex(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (zzbde.zzd(zzbboVar2) != null) {
                zzazk.zzex("Precache task is already running.");
                return;
            } else if (zzbboVar2.zzabf() == null) {
                zzazk.zzex("Precache requires a dependency provider.");
                return;
            } else {
                zzbbl zzbblVar = new zzbbl((String) map.get("flags"));
                Integer zza2 = zza(map, "player");
                if (zza2 == null) {
                    zza2 = 0;
                }
                if (zza != null) {
                    zzbboVar2.zzdp(zza.intValue());
                }
                zzbddVar = zzbboVar2.zzabf().zzbok.zza(zzbboVar2, zza2.intValue(), null, zzbblVar);
                new zzbdc(zzbboVar2, zzbddVar, str, strArr).zzye();
            }
        } else {
            zzbdc zzd = zzbde.zzd(zzbboVar2);
            if (zzd != null) {
                zzbddVar = zzd.zzepm;
            } else {
                zzazk.zzex("Precache must specify a source.");
                return;
            }
        }
        Integer zza3 = zza(map, "minBufferMs");
        if (zza3 != null) {
            zzbddVar.zzdk(zza3.intValue());
        }
        Integer zza4 = zza(map, "maxBufferMs");
        if (zza4 != null) {
            zzbddVar.zzdl(zza4.intValue());
        }
        Integer zza5 = zza(map, "bufferForPlaybackMs");
        if (zza5 != null) {
            zzbddVar.zzdm(zza5.intValue());
        }
        Integer zza6 = zza(map, "bufferForPlaybackAfterRebufferMs");
        if (zza6 != null) {
            zzbddVar.zzdn(zza6.intValue());
        }
    }
}
