package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.d;
/* loaded from: classes2.dex */
final class zzz extends zzab {
    private final /* synthetic */ d zzcl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzq zzqVar, GoogleApiClient googleApiClient, d dVar) {
        super(googleApiClient);
        this.zzcl = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zza(k.b(this.zzcl, d.class.getSimpleName()), new zzac(this));
    }
}
