package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.location.LocationSettingsResult;
/* loaded from: classes2.dex */
final class zzbc extends zzar {
    private d<LocationSettingsResult> zzdf;

    public zzbc(d<LocationSettingsResult> dVar) {
        q.b(dVar != null, "listener can't be null.");
        this.zzdf = dVar;
    }

    @Override // com.google.android.gms.internal.location.zzaq
    public final void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.zzdf.setResult(locationSettingsResult);
        this.zzdf = null;
    }
}
