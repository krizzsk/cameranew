package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdqs implements zzeqb<ThreadFactory> {
    public static zzdqs zzaxf() {
        zzdqs zzdqsVar;
        zzdqsVar = zzdqr.zzhpr;
        return zzdqsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (ThreadFactory) zzeqh.zza(new zzdqe(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
