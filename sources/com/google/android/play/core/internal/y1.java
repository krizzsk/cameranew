package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class y1 extends r1 implements z1 {
    public y1() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    @Override // com.google.android.play.core.internal.r1
    protected final boolean x0(int i2, Parcel parcel) throws RemoteException {
        b2 b2Var = null;
        if (i2 == 2) {
            Bundle bundle = (Bundle) s1.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                b2Var = queryLocalInterface instanceof b2 ? (b2) queryLocalInterface : new a2(readStrongBinder);
            }
            L(bundle, b2Var);
            return true;
        } else if (i2 != 3) {
            return false;
        } else {
            Bundle bundle2 = (Bundle) s1.a(parcel, Bundle.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                b2Var = queryLocalInterface2 instanceof b2 ? (b2) queryLocalInterface2 : new a2(readStrongBinder2);
            }
            T(b2Var);
            return true;
        }
    }
}
