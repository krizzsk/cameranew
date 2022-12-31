package com.google.android.gms.ads.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzazn;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zze {
    private Context a;
    private long b = 0;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (r11.zzxx() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(android.content.Context r8, com.google.android.gms.internal.ads.zzazn r9, boolean r10, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzayp r11, java.lang.String r12, @androidx.annotation.Nullable java.lang.String r13, @androidx.annotation.Nullable java.lang.Runnable r14) {
        /*
            r7 = this;
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzky()
            long r0 = r0.a()
            long r2 = r7.b
            long r0 = r0 - r2
            r2 = 5000(0x1388, double:2.4703E-320)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L17
            java.lang.String r8 = "Not retrying to fetch app settings"
            com.google.android.gms.internal.ads.zzazk.zzex(r8)
            return
        L17:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzr.zzky()
            long r0 = r0.a()
            r7.b = r0
            r0 = 0
            r1 = 1
            if (r11 != 0) goto L27
        L25:
            r0 = 1
            goto L54
        L27:
            long r2 = r11.zzxw()
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzr.zzky()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            com.google.android.gms.internal.ads.zzaba<java.lang.Long> r2 = com.google.android.gms.internal.ads.zzabp.zzctw
            com.google.android.gms.internal.ads.zzabl r3 = com.google.android.gms.internal.ads.zzwr.zzqr()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L4a
            r2 = 1
            goto L4b
        L4a:
            r2 = 0
        L4b:
            if (r2 != 0) goto L25
            boolean r11 = r11.zzxx()
            if (r11 != 0) goto L54
            goto L25
        L54:
            if (r0 != 0) goto L57
            return
        L57:
            if (r8 != 0) goto L5f
            java.lang.String r8 = "Context not provided to fetch application settings"
            com.google.android.gms.internal.ads.zzazk.zzex(r8)
            return
        L5f:
            boolean r11 = android.text.TextUtils.isEmpty(r12)
            if (r11 == 0) goto L71
            boolean r11 = android.text.TextUtils.isEmpty(r13)
            if (r11 == 0) goto L71
            java.lang.String r8 = "App settings could not be fetched. Required parameters missing"
            com.google.android.gms.internal.ads.zzazk.zzex(r8)
            return
        L71:
            android.content.Context r11 = r8.getApplicationContext()
            if (r11 == 0) goto L78
            goto L79
        L78:
            r11 = r8
        L79:
            r7.a = r11
            com.google.android.gms.internal.ads.zzama r11 = com.google.android.gms.ads.internal.zzr.zzle()
            android.content.Context r0 = r7.a
            com.google.android.gms.internal.ads.zzamj r9 = r11.zzb(r0, r9)
            com.google.android.gms.internal.ads.zzamf<org.json.JSONObject> r11 = com.google.android.gms.internal.ads.zzame.zzdks
            java.lang.String r0 = "google.afma.config.fetchAppSettings"
            com.google.android.gms.internal.ads.zzamb r9 = r9.zza(r0, r11, r11)
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch: java.lang.Exception -> Lce
            r11.<init>()     // Catch: java.lang.Exception -> Lce
            boolean r0 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Exception -> Lce
            if (r0 != 0) goto L9e
            java.lang.String r13 = "app_id"
            r11.put(r13, r12)     // Catch: java.lang.Exception -> Lce
            goto La9
        L9e:
            boolean r12 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Exception -> Lce
            if (r12 != 0) goto La9
            java.lang.String r12 = "ad_unit_id"
            r11.put(r12, r13)     // Catch: java.lang.Exception -> Lce
        La9:
            java.lang.String r12 = "is_init"
            r11.put(r12, r10)     // Catch: java.lang.Exception -> Lce
            java.lang.String r10 = "pn"
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Exception -> Lce
            r11.put(r10, r8)     // Catch: java.lang.Exception -> Lce
            com.google.android.gms.internal.ads.zzdzw r8 = r9.zzh(r11)     // Catch: java.lang.Exception -> Lce
            com.google.android.gms.internal.ads.zzdyu r9 = com.google.android.gms.ads.internal.a.a     // Catch: java.lang.Exception -> Lce
            com.google.android.gms.internal.ads.zzdzv r10 = com.google.android.gms.internal.ads.zzazp.zzeih     // Catch: java.lang.Exception -> Lce
            com.google.android.gms.internal.ads.zzdzw r9 = com.google.android.gms.internal.ads.zzdzk.zzb(r8, r9, r10)     // Catch: java.lang.Exception -> Lce
            if (r14 == 0) goto Lc8
            r8.addListener(r14, r10)     // Catch: java.lang.Exception -> Lce
        Lc8:
            java.lang.String r8 = "ConfigLoader.maybeFetchNewAppSettings"
            com.google.android.gms.internal.ads.zzazw.zza(r9, r8)     // Catch: java.lang.Exception -> Lce
            return
        Lce:
            r8 = move-exception
            java.lang.String r9 = "Error requesting application settings"
            com.google.android.gms.internal.ads.zzazk.zzc(r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zze.a(android.content.Context, com.google.android.gms.internal.ads.zzazn, boolean, com.google.android.gms.internal.ads.zzayp, java.lang.String, java.lang.String, java.lang.Runnable):void");
    }

    public final void zza(Context context, zzazn zzaznVar, String str, @Nullable Runnable runnable) {
        a(context, zzaznVar, true, null, str, null, runnable);
    }

    public final void zza(Context context, zzazn zzaznVar, String str, zzayp zzaypVar) {
        a(context, zzaznVar, false, zzaypVar, zzaypVar != null ? zzaypVar.zzxz() : null, str, null);
    }
}
