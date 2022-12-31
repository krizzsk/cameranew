package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzakk {
    public static void zza(zzakl zzaklVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzaklVar.zzi(str, jSONObject.toString());
    }

    public static void zzb(zzakl zzaklVar, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzazk.zzdy(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzaklVar.zzcv(sb.toString());
    }

    public static void zza(zzakl zzaklVar, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzaklVar.zzcv(sb.toString());
    }

    public static void zza(zzakl zzaklVar, String str, Map map) {
        try {
            zzaklVar.zza(str, com.google.android.gms.ads.internal.zzr.zzkr().zzj(map));
        } catch (JSONException unused) {
            zzazk.zzex("Could not convert parameters to JSON.");
        }
    }
}
