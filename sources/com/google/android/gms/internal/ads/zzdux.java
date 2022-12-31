package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.j;
import java.io.File;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdux {
    private static final Object zzhur = new Object();
    private final Context context;
    private final SharedPreferences zzcme;
    private final String zzhuo;
    private final zzdug zzhup;
    private boolean zzhuq;

    public zzdux(@NonNull Context context, @NonNull zzgp zzgpVar, @NonNull zzdug zzdugVar, boolean z) {
        this(context, zzgpVar, zzdugVar);
        this.zzhuq = z;
    }

    private final String zzays() {
        String valueOf = String.valueOf(this.zzhuo);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzayt() {
        String valueOf = String.valueOf(this.zzhuo);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private static String zzb(@NonNull zzgr zzgrVar) {
        return j.a(((zzgv) ((zzelb) zzgv.zzdl().zzav(zzgrVar.zzdc().zzdg()).zzaw(zzgrVar.zzdc().zzdh()).zzdk(zzgrVar.zzdc().zzdj()).zzdl(zzgrVar.zzdc().zzdk()).zzdj(zzgrVar.zzdc().zzdi()).zzbiw())).zzbfz().toByteArray());
    }

    private final zzgv zzej(int i2) {
        String string;
        zzeko zzbhx;
        if (i2 == zzdva.zzhut) {
            string = this.zzcme.getString(zzayt(), null);
        } else {
            string = i2 == zzdva.zzhuu ? this.zzcme.getString(zzays(), null) : null;
        }
        if (string == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzejr zzt = zzejr.zzt(j.c(string));
            if (this.zzhuq) {
                zzbhx = zzeko.zzbhw();
            } else {
                zzbhx = zzeko.zzbhx();
            }
            return zzgv.zzb(zzt, zzbhx);
        } catch (zzelo unused) {
            return null;
        } catch (NullPointerException unused2) {
            zza(2029, currentTimeMillis);
            return null;
        }
    }

    private final File zzhj(@NonNull String str) {
        return new File(new File(this.context.getDir("pccache", 0), this.zzhuo), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1 A[Catch: all -> 0x018a, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:11:0x002d, B:13:0x003d, B:17:0x004a, B:21:0x0055, B:35:0x00b1, B:37:0x00b3, B:39:0x00d3, B:40:0x00d8, B:42:0x00da, B:44:0x00e8, B:45:0x00ed, B:48:0x00f1, B:50:0x00f7, B:51:0x00ff, B:53:0x0101, B:55:0x0123, B:56:0x012a, B:58:0x0130, B:60:0x0137, B:62:0x0139, B:64:0x0144, B:65:0x014b, B:67:0x0153, B:68:0x015a, B:70:0x0170, B:72:0x017c, B:73:0x017f, B:74:0x0182, B:75:0x0187, B:22:0x0081, B:24:0x0087, B:28:0x0096, B:30:0x009c, B:32:0x00a6, B:31:0x00a1), top: B:81:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3 A[Catch: all -> 0x018a, TryCatch #0 {, blocks: (B:4:0x000b, B:6:0x001c, B:8:0x0026, B:9:0x002b, B:11:0x002d, B:13:0x003d, B:17:0x004a, B:21:0x0055, B:35:0x00b1, B:37:0x00b3, B:39:0x00d3, B:40:0x00d8, B:42:0x00da, B:44:0x00e8, B:45:0x00ed, B:48:0x00f1, B:50:0x00f7, B:51:0x00ff, B:53:0x0101, B:55:0x0123, B:56:0x012a, B:58:0x0130, B:60:0x0137, B:62:0x0139, B:64:0x0144, B:65:0x014b, B:67:0x0153, B:68:0x015a, B:70:0x0170, B:72:0x017c, B:73:0x017f, B:74:0x0182, B:75:0x0187, B:22:0x0081, B:24:0x0087, B:28:0x0096, B:30:0x009c, B:32:0x00a6, B:31:0x00a1), top: B:81:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzgr r18, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzduy r19) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdux.zza(com.google.android.gms.internal.ads.zzgr, com.google.android.gms.internal.ads.zzduy):boolean");
    }

    public final boolean zzek(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhur) {
            zzgv zzej = zzej(i2);
            if (zzej == null) {
                zza(4025, currentTimeMillis);
                return false;
            }
            File zzhj = zzhj(zzej.zzdg());
            if (!new File(zzhj, "pcam.jar").exists()) {
                zza(4026, currentTimeMillis);
                return false;
            } else if (!new File(zzhj, "pcbc").exists()) {
                zza(4027, currentTimeMillis);
                return false;
            } else {
                zza(5019, currentTimeMillis);
                return true;
            }
        }
    }

    @Nullable
    public final zzdup zzp(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhur) {
            zzgv zzej = zzej(i2);
            if (zzej == null) {
                zza(4022, currentTimeMillis);
                return null;
            }
            File zzhj = zzhj(zzej.zzdg());
            File file = new File(zzhj, "pcam.jar");
            if (!file.exists()) {
                file = new File(zzhj, "pcam");
            }
            File file2 = new File(zzhj, "pcbc");
            File file3 = new File(zzhj, "pcopt");
            zza(5016, currentTimeMillis);
            return new zzdup(zzej, file, file2, file3);
        }
    }

    private zzdux(@NonNull Context context, @NonNull zzgp zzgpVar, @NonNull zzdug zzdugVar) {
        this.zzhuq = false;
        this.context = context;
        this.zzhuo = Integer.toString(zzgpVar.zzv());
        this.zzcme = context.getSharedPreferences("pcvmspf", 0);
        this.zzhup = zzdugVar;
    }

    public final boolean zza(@NonNull zzgr zzgrVar) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhur) {
            if (!zzdur.zza(new File(zzhj(zzgrVar.zzdc().zzdg()), "pcbc"), zzgrVar.zzde().toByteArray())) {
                zza(4020, currentTimeMillis);
                return false;
            }
            String zzb = zzb(zzgrVar);
            SharedPreferences.Editor edit = this.zzcme.edit();
            edit.putString(zzayt(), zzb);
            boolean commit = edit.commit();
            if (commit) {
                zza(5015, currentTimeMillis);
            } else {
                zza(4021, currentTimeMillis);
            }
            return commit;
        }
    }

    private final void zza(int i2, long j2) {
        zzdug zzdugVar = this.zzhup;
        if (zzdugVar != null) {
            zzdugVar.zza(i2, j2);
        }
    }

    private final void zza(int i2, long j2, String str) {
        zzdug zzdugVar = this.zzhup;
        if (zzdugVar != null) {
            zzdugVar.zza(i2, j2, str);
        }
    }
}
