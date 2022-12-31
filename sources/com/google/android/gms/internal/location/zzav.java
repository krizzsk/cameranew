package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.c;
/* loaded from: classes2.dex */
final class zzav implements j.b<c> {
    private final /* synthetic */ LocationAvailability zzdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzat zzatVar, LocationAvailability locationAvailability) {
        this.zzdc = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final /* synthetic */ void notifyListener(c cVar) {
        cVar.a(this.zzdc);
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final void onNotifyListenerFailed() {
    }
}
