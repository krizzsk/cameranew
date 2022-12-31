package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbxd implements zzeqb<Set<zzbya<VideoController.VideoLifecycleCallbacks>>> {
    private final zzbwg zzgav;

    private zzbxd(zzbwg zzbwgVar) {
        this.zzgav = zzbwgVar;
    }

    public static zzbxd zzac(zzbwg zzbwgVar) {
        return new zzbxd(zzbwgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (Set) zzeqh.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
