package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.c;
/* loaded from: classes2.dex */
final class zzs extends zzab {
    private final /* synthetic */ c zzcm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzs(zzq zzqVar, GoogleApiClient googleApiClient, c cVar) {
        super(googleApiClient);
        this.zzcm = cVar;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zzb(k.b(this.zzcm, c.class.getSimpleName()), new zzac(this));
    }
}
