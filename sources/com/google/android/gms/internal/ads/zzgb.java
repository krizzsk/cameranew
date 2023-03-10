package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgb extends zzgn {
    public zzgb(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        zzem zzemVar = new zzem((String) this.zzabl.invoke(null, this.zzwc.getContext(), Boolean.valueOf(((Boolean) zzwr.zzqr().zzd(zzabp.zzcsd)).booleanValue())));
        synchronized (this.zzabb) {
            this.zzabb.zzal(zzemVar.zzyg);
            this.zzabb.zzbn(zzemVar.zzyh);
        }
    }
}
