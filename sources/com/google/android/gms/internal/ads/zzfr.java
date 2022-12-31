package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfr extends zzgn {
    public zzfr(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzam(-1L);
        this.zzabb.zzan(-1L);
        int[] iArr = (int[]) this.zzabl.invoke(null, this.zzwc.getContext());
        synchronized (this.zzabb) {
            this.zzabb.zzam(iArr[0]);
            this.zzabb.zzan(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzabb.zzbm(iArr[2]);
            }
        }
    }
}
