package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzclb implements zzeqb<zzclc> {
    private final zzeqo<Clock> zzfsz;

    public zzclb(zzeqo<Clock> zzeqoVar) {
        this.zzfsz = zzeqoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzclc(this.zzfsz.get());
    }
}
