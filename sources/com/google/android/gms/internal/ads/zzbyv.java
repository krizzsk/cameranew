package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbyv implements zzeqb<zzbyp> {
    private final zzeqo<Set<zzbya<VideoController.VideoLifecycleCallbacks>>> zzfvd;

    private zzbyv(zzeqo<Set<zzbya<VideoController.VideoLifecycleCallbacks>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbyv zzv(zzeqo<Set<zzbya<VideoController.VideoLifecycleCallbacks>>> zzeqoVar) {
        return new zzbyv(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbyp(this.zzfvd.get());
    }
}
