package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgf extends zzgn {
    private final StackTraceElement[] zzabg;

    public zzgf(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3, StackTraceElement[] stackTraceElementArr) {
        super(zzfcVar, str, str2, zzbVar, i2, 45);
        this.zzabg = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        zzcq zzcqVar;
        StackTraceElement[] stackTraceElementArr = this.zzabg;
        if (stackTraceElementArr != null) {
            zzey zzeyVar = new zzey((String) this.zzabl.invoke(null, stackTraceElementArr));
            synchronized (this.zzabb) {
                this.zzabb.zzbi(zzeyVar.zzyq.longValue());
                if (zzeyVar.zzyr.booleanValue()) {
                    zzcf.zza.zzb zzbVar = this.zzabb;
                    if (zzeyVar.zzys.booleanValue()) {
                        zzcqVar = zzcq.ENUM_FALSE;
                    } else {
                        zzcqVar = zzcq.ENUM_TRUE;
                    }
                    zzbVar.zzh(zzcqVar);
                } else {
                    this.zzabb.zzh(zzcq.ENUM_FAILURE);
                }
            }
        }
    }
}
