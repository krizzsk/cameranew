package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzckn {
    private final Executor executor;
    private final zzckw zzglo;
    private final Map<String, String> zzgls;

    public zzckn(zzckw zzckwVar, Executor executor) {
        this.zzglo = zzckwVar;
        this.zzgls = zzckwVar.zzaqx();
        this.executor = executor;
    }

    public final zzckq zzaqr() {
        return zzckq.zzb(new zzckq(this));
    }
}
