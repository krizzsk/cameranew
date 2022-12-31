package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgg extends zzgn {
    private final boolean zzabh;

    public zzgg(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 61);
        this.zzabh = zzfcVar.zzcf();
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzabl.invoke(null, this.zzwc.getContext(), Boolean.valueOf(this.zzabh))).longValue();
        synchronized (this.zzabb) {
            this.zzabb.zzbo(longValue);
        }
    }
}
