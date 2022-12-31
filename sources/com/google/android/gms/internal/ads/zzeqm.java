package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeqm<T> {
    private final List<zzeqo<T>> zzjcd;
    private final List<zzeqo<Collection<T>>> zzjce;

    private zzeqm(int i2, int i3) {
        this.zzjcd = zzeqa.zzid(i2);
        this.zzjce = zzeqa.zzid(i3);
    }

    public final zzeqm<T> zzaw(zzeqo<? extends T> zzeqoVar) {
        this.zzjcd.add(zzeqoVar);
        return this;
    }

    public final zzeqm<T> zzax(zzeqo<? extends Collection<? extends T>> zzeqoVar) {
        this.zzjce.add(zzeqoVar);
        return this;
    }

    public final zzeqk<T> zzbmo() {
        return new zzeqk<>(this.zzjcd, this.zzjce);
    }
}
