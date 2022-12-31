package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class zzckw extends zzckv {
    private final zzdsh zzgmd;

    public zzckw(Executor executor, zzazo zzazoVar, zzdsh zzdshVar, zzdsj zzdsjVar) {
        super(executor, zzazoVar, zzdsjVar);
        this.zzgmd = zzdshVar;
        zzaqw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzckv
    public final void zzaqw() {
        this.zzgmd.zzq(this.zzgls);
    }

    public final Map<String, String> zzaqx() {
        return new HashMap(this.zzgls);
    }
}
