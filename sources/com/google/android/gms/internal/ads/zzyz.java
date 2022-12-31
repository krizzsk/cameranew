package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzyz extends zzgw implements zzyx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzyz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final List<zzvw> getAdapterResponses() throws RemoteException {
        Parcel zza = zza(3, zzdo());
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzvw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel zza = zza(1, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzyx
    public final String getResponseId() throws RemoteException {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
