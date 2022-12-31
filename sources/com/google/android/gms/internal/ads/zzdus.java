package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.j;
import java.io.File;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdus {
    private final SharedPreferences zzcme;
    private final File zzhuk;
    private final File zzhul;
    private final zzgp zzvu;

    public zzdus(@NonNull Context context, zzgp zzgpVar) {
        this.zzcme = context.getSharedPreferences("pcvmspf", 0);
        this.zzhuk = zzdur.zza(context.getDir("pccache", 0), false);
        this.zzhul = zzdur.zza(context.getDir("tmppccache", 0), true);
        this.zzvu = zzgpVar;
    }

    private final File zzayr() {
        File file = new File(this.zzhuk, Integer.toString(this.zzvu.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zzays() {
        int zzv = this.zzvu.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(zzv);
        return sb.toString();
    }

    private final String zzayt() {
        int zzv = this.zzvu.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(zzv);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzgv zzej(int r6) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.internal.ads.zzdva.zzhut
            r1 = 0
            if (r6 != r0) goto L10
            android.content.SharedPreferences r6 = r5.zzcme
            java.lang.String r0 = r5.zzayt()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L10:
            int r0 = com.google.android.gms.internal.ads.zzdva.zzhuu
            if (r6 != r0) goto L1f
            android.content.SharedPreferences r6 = r5.zzcme
            java.lang.String r0 = r5.zzays()
            java.lang.String r6 = r6.getString(r0, r1)
            goto L20
        L1f:
            r6 = r1
        L20:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L27
            return r1
        L27:
            byte[] r6 = com.google.android.gms.common.util.j.c(r6)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            com.google.android.gms.internal.ads.zzejr r6 = com.google.android.gms.internal.ads.zzejr.zzt(r6)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            com.google.android.gms.internal.ads.zzgv r6 = com.google.android.gms.internal.ads.zzgv.zzl(r6)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            java.lang.String r0 = r6.zzdg()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            java.lang.String r2 = "pcam.jar"
            java.io.File r3 = r5.zzayr()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            java.io.File r2 = com.google.android.gms.internal.ads.zzdur.zza(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            boolean r3 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            if (r3 != 0) goto L51
            java.lang.String r2 = "pcam"
            java.io.File r3 = r5.zzayr()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            java.io.File r2 = com.google.android.gms.internal.ads.zzdur.zza(r0, r2, r3)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
        L51:
            java.lang.String r3 = "pcbc"
            java.io.File r4 = r5.zzayr()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            java.io.File r0 = com.google.android.gms.internal.ads.zzdur.zza(r0, r3, r4)     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            boolean r2 = r2.exists()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            if (r2 == 0) goto L69
            boolean r0 = r0.exists()     // Catch: com.google.android.gms.internal.ads.zzelo -> L6d
            if (r0 == 0) goto L69
            r0 = 1
            goto L6a
        L69:
            r0 = 0
        L6a:
            if (r0 == 0) goto L6d
            return r6
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdus.zzej(int):com.google.android.gms.internal.ads.zzgv");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0140, code lost:
        if (r0.commit() != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgr r9, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzduy r10) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdus.zza(com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzduy):boolean");
    }

    public final zzdup zzp(int i2) {
        zzgv zzej = zzej(i2);
        if (zzej == null) {
            return null;
        }
        String zzdg = zzej.zzdg();
        File zza = zzdur.zza(zzdg, "pcam.jar", zzayr());
        if (!zza.exists()) {
            zza = zzdur.zza(zzdg, "pcam", zzayr());
        }
        return new zzdup(zzej, zza, zzdur.zza(zzdg, "pcbc", zzayr()), zzdur.zza(zzdg, "pcopt", zzayr()));
    }

    private static String zza(@NonNull zzgv zzgvVar) {
        return j.a(zzgvVar.zzbfz().toByteArray());
    }
}
