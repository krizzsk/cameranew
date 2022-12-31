package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.c;
import com.google.android.gms.location.g0;
/* loaded from: classes2.dex */
final class zzat extends g0 {
    private final j<c> zzda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(j<c> jVar) {
        this.zzda = jVar;
    }

    @Override // com.google.android.gms.location.f0
    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        this.zzda.c(new zzav(this, locationAvailability));
    }

    @Override // com.google.android.gms.location.f0
    public final void onLocationResult(LocationResult locationResult) {
        this.zzda.c(new zzau(this, locationResult));
    }

    public final synchronized void release() {
        this.zzda.a();
    }
}
