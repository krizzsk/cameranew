package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.h;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdoo implements zzeqb<Clock> {
    private final zzdol zzhmi;

    public zzdoo(zzdol zzdolVar) {
        this.zzhmi = zzdolVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Clock) zzeqh.zza(h.getInstance(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
