package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzge extends zzgn {
    public zzge(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        try {
            this.zzabb.zzi(((Boolean) this.zzabl.invoke(null, this.zzwc.getContext())).booleanValue() ? zzcq.ENUM_TRUE : zzcq.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzabb.zzi(zzcq.ENUM_FAILURE);
        }
    }
}
