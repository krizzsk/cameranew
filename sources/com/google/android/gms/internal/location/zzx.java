package com.google.android.gms.internal.location;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.c;
/* loaded from: classes2.dex */
final class zzx extends zzab {
    private final /* synthetic */ LocationRequest zzck;
    private final /* synthetic */ c zzcm;
    private final /* synthetic */ Looper zzcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzq zzqVar, GoogleApiClient googleApiClient, LocationRequest locationRequest, c cVar, Looper looper) {
        super(googleApiClient);
        this.zzck = locationRequest;
        this.zzcm = cVar;
        this.zzcp = looper;
    }

    @Override // com.google.android.gms.common.api.internal.c
    protected final /* synthetic */ void doExecute(zzaz zzazVar) throws RemoteException {
        zzazVar.zza(zzbd.zza(this.zzck), k.a(this.zzcm, zzbm.zza(this.zzcp), c.class.getSimpleName()), new zzac(this));
    }
}
