package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
/* loaded from: classes2.dex */
final class zzv extends zzab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzq zzqVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zza(new zzac(this));
    }
}
