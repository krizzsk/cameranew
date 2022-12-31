package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbvv implements zzeqb<zzbvt> {
    private final zzeqo<Set<zzbya<AppEventListener>>> zzfvd;

    private zzbvv(zzeqo<Set<zzbya<AppEventListener>>> zzeqoVar) {
        this.zzfvd = zzeqoVar;
    }

    public static zzbvv zzr(zzeqo<Set<zzbya<AppEventListener>>> zzeqoVar) {
        return new zzbvv(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzbvt(this.zzfvd.get());
    }
}
