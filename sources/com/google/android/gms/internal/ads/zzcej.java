package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcej implements zzeqb<zzbya<VideoController.VideoLifecycleCallbacks>> {
    private final zzeqo<zzcgx> zzewe;
    private final zzeqo<Executor> zzfux;
    private final zzcee zzghg;

    public zzcej(zzcee zzceeVar, zzeqo<zzcgx> zzeqoVar, zzeqo<Executor> zzeqoVar2) {
        this.zzghg = zzceeVar;
        this.zzewe = zzeqoVar;
        this.zzfux = zzeqoVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return (zzbya) zzeqh.zza(new zzbya(this.zzewe.get(), this.zzfux.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
