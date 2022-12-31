package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbra implements zzeqb<Bundle> {
    private final zzbqx zzfyz;

    private zzbra(zzbqx zzbqxVar) {
        this.zzfyz = zzbqxVar;
    }

    public static zzbra zzh(zzbqx zzbqxVar) {
        return new zzbra(zzbqxVar);
    }

    @Nullable
    public static Bundle zzi(zzbqx zzbqxVar) {
        return zzbqxVar.zzaln();
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfyz.zzaln();
    }
}
