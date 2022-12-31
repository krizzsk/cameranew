package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzft extends zzgn {
    private long startTime;

    public zzft(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, long j2, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 25);
        this.startTime = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabl.invoke(null, new Object[0])).longValue();
        synchronized (this.zzabb) {
            this.zzabb.zzbr(longValue);
            long j2 = this.startTime;
            if (j2 != 0) {
                this.zzabb.zzat(longValue - j2);
                this.zzabb.zzaw(this.startTime);
            }
        }
    }
}
