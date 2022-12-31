package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzdzw;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zza {
    private volatile Thread thread;
    private final Runnable zzedk = new s(this);
    private boolean zzedl = false;

    public abstract void zzwe();

    public final zzdzw<?> zzye() {
        return zzazp.zzeid.zzg(this.zzedk);
    }
}
