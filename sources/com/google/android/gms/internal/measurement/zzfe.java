package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzfe {
    final Uri zzb;
    final String zza = null;
    final String zzc = "";
    final String zzd = "";
    final boolean zze = false;
    final boolean zzf = false;
    final boolean zzg = false;
    final boolean zzh = false;
    @Nullable
    final zzfl<Context, Boolean> zzi = null;

    public zzfe(Uri uri) {
        this.zzb = uri;
    }

    public final zzfg<Long> zza(String str, long j2) {
        return new zzfa(this, str, Long.valueOf(j2), true);
    }

    public final zzfg<Boolean> zzb(String str, boolean z) {
        return new zzfb(this, str, Boolean.valueOf(z), true);
    }

    public final zzfg<Double> zzc(String str, double d2) {
        return new zzfc(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzfg<String> zzd(String str, String str2) {
        return new zzfd(this, str, str2, true);
    }
}
