package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzza extends zzgy implements zzyx {
    public zzza() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzyx zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzyx) {
            return (zzyx) queryLocalInterface;
        }
        return new zzyz(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzgy
    protected final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i2 == 2) {
            String responseId = getResponseId();
            parcel2.writeNoException();
            parcel2.writeString(responseId);
        } else if (i2 != 3) {
            return false;
        } else {
            List<zzvw> adapterResponses = getAdapterResponses();
            parcel2.writeNoException();
            parcel2.writeTypedList(adapterResponses);
        }
        return true;
    }
}
