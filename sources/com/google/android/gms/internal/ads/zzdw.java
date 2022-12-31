package com.google.android.gms.internal.ads;

import android.os.Build;
import android.os.ConditionVariable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzdw {
    private static final ConditionVariable zzwd = new ConditionVariable();
    @VisibleForTesting
    protected static volatile zztz zzwe = null;
    private static volatile Random zzwg = null;
    private zzfc zzwc;
    @VisibleForTesting
    protected volatile Boolean zzwf;

    public zzdw(zzfc zzfcVar) {
        this.zzwc = zzfcVar;
        zzfcVar.zzcg().execute(new zzdv(this));
    }

    public static int zzbu() {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                return ThreadLocalRandom.current().nextInt();
            }
            return zzbv().nextInt();
        } catch (RuntimeException unused) {
            return zzbv().nextInt();
        }
    }

    private static Random zzbv() {
        if (zzwg == null) {
            synchronized (zzdw.class) {
                if (zzwg == null) {
                    zzwg = new Random();
                }
            }
        }
        return zzwg;
    }

    public final void zza(int i2, int i3, long j2) {
        zza(i2, i3, j2, null, null);
    }

    public final void zza(int i2, int i3, long j2, String str) {
        zza(i2, -1, j2, str, null);
    }

    public final void zza(int i2, int i3, long j2, String str, Exception exc) {
        try {
            zzwd.block();
            if (!this.zzwf.booleanValue() || zzwe == null) {
                return;
            }
            zzbw.zza.zzb zzd = zzbw.zza.zzs().zzo(this.zzwc.context.getPackageName()).zzd(j2);
            if (str != null) {
                zzd.zzr(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                zzeja.zza(exc, new PrintWriter(stringWriter));
                zzd.zzp(stringWriter.toString()).zzq(exc.getClass().getName());
            }
            zzud zzf = zzwe.zzf(((zzbw.zza) ((zzelb) zzd.zzbiw())).toByteArray());
            zzf.zzbv(i2);
            if (i3 != -1) {
                zzf.zzbu(i3);
            }
            zzf.log();
        } catch (Exception unused) {
        }
    }
}
