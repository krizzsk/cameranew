package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaas extends zzagk {
    private final ShouldDelayBannerRenderingListener zzclt;

    public zzaas(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzclt = shouldDelayBannerRenderingListener;
    }

    @Override // com.google.android.gms.internal.ads.zzagl
    public final boolean zzm(b bVar) throws RemoteException {
        return this.zzclt.shouldDelayBannerRendering((Runnable) d.y0(bVar));
    }
}
