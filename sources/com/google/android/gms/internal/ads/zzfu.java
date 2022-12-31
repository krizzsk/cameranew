package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzfu extends zzgn {
    private static volatile Long zzaaz;
    private static final Object zzaba = new Object();

    public zzfu(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 44);
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (zzaaz == null) {
            synchronized (zzaba) {
                if (zzaaz == null) {
                    zzaaz = (Long) this.zzabl.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.zzabb) {
            this.zzabb.zzbh(zzaaz.longValue());
        }
    }
}
