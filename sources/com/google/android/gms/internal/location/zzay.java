package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.d;
/* loaded from: classes2.dex */
final class zzay implements j.b<d> {
    private final /* synthetic */ Location zzdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzax zzaxVar, Location location) {
        this.zzdd = location;
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final /* synthetic */ void notifyListener(d dVar) {
        dVar.onLocationChanged(this.zzdd);
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final void onNotifyListenerFailed() {
    }
}
