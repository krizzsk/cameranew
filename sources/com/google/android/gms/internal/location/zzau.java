package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.j;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.c;
/* loaded from: classes2.dex */
final class zzau implements j.b<c> {
    private final /* synthetic */ LocationResult zzdb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzau(zzat zzatVar, LocationResult locationResult) {
        this.zzdb = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final /* synthetic */ void notifyListener(c cVar) {
        cVar.b(this.zzdb);
    }

    @Override // com.google.android.gms.common.api.internal.j.b
    public final void onNotifyListenerFailed() {
    }
}
