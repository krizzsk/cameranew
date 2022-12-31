package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
/* loaded from: classes2.dex */
final class zzac extends zzak {
    private final d<Status> zzcq;

    public zzac(d<Status> dVar) {
        this.zzcq = dVar;
    }

    @Override // com.google.android.gms.internal.location.zzaj
    public final void zza(zzad zzadVar) {
        this.zzcq.setResult(zzadVar.getStatus());
    }
}
