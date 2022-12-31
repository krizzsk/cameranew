package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgd extends zzgn {
    private List<Long> zzabf;

    public zzgd(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3) {
        super(zzfcVar, str, str2, zzbVar, i2, 31);
        this.zzabf = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        this.zzabb.zzax(-1L);
        this.zzabb.zzay(-1L);
        if (this.zzabf == null) {
            this.zzabf = (List) this.zzabl.invoke(null, this.zzwc.getContext());
        }
        List<Long> list = this.zzabf;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.zzabb) {
            this.zzabb.zzax(this.zzabf.get(0).longValue());
            this.zzabb.zzay(this.zzabf.get(1).longValue());
        }
    }
}
