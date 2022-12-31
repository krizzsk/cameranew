package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.d;
import com.google.android.gms.location.j0;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes2.dex */
final class zzax extends j0 {
    private final j<d> zzda;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(j<d> jVar) {
        this.zzda = jVar;
    }

    @Override // com.google.android.gms.location.i0
    @Instrumented
    public final synchronized void onLocationChanged(Location location) {
        VdsAgent.onLocationChanged(this, location);
        this.zzda.c(new zzay(this, location));
    }

    public final synchronized void release() {
        this.zzda.a();
    }
}
