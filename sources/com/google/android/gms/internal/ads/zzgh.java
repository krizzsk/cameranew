package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgh extends zzgn {
    private long zzaam;
    private final zzfj zzxj;

    public zzgh(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3, zzfj zzfjVar) {
        super(zzfcVar, str, str2, zzbVar, i2, 53);
        this.zzxj = zzfjVar;
        if (zzfjVar != null) {
            this.zzaam = zzfjVar.zzcu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzxj != null) {
            this.zzabb.zzbl(((Long) this.zzabl.invoke(null, Long.valueOf(this.zzaam))).longValue());
        }
    }
}
