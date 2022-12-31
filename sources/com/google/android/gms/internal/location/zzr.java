package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.d;
/* loaded from: classes2.dex */
final class zzr extends zzab {
    private final /* synthetic */ LocationRequest zzck;
    private final /* synthetic */ d zzcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(zzq zzqVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, d dVar) {
        super(googleApiClient);
        this.zzck = locationRequest;
        this.zzcl = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zza(this.zzck, k.a(this.zzcl, zzbm.zzc(), d.class.getSimpleName()), new zzac(this));
    }
}
