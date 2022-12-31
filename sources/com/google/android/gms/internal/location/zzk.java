package com.google.android.gms.internal.location;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.g;
/* loaded from: classes2.dex */
public class zzk extends g<zzao> {
    private final String zzca;
    protected final zzbj<zzao> zzcb;

    public zzk(Context context, Looper looper, GoogleApiClient.a aVar, GoogleApiClient.b bVar, String str, d dVar) {
        super(context, looper, 23, dVar, aVar, bVar);
        this.zzcb = new zzl(this);
        this.zzca = str;
    }

    @Override // com.google.android.gms.common.internal.c
    protected /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzao ? (zzao) queryLocalInterface : new zzap(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    protected Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzca);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.g, com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public int getMinApkVersion() {
        return 11925000;
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getServiceDescriptor() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getStartServiceAction() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
