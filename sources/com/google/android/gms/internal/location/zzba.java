package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.location.f;
/* loaded from: classes2.dex */
final class zzba extends zzan {
    private d<Status> zzdf;

    public zzba(d<Status> dVar) {
        this.zzdf = dVar;
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zza(int i2, PendingIntent pendingIntent) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByPendingIntentResult");
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zza(int i2, String[] strArr) {
        if (this.zzdf == null) {
            Log.wtf("LocationClientImpl", "onAddGeofenceResult called multiple times");
            return;
        }
        this.zzdf.setResult(f.b(f.a(i2)));
        this.zzdf = null;
    }

    @Override // com.google.android.gms.internal.location.zzam
    public final void zzb(int i2, String[] strArr) {
        Log.wtf("LocationClientImpl", "Unexpected call to onRemoveGeofencesByRequestIdsResult");
    }
}
