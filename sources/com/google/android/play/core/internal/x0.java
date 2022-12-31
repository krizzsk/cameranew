package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class x0 extends r1 implements y0 {
    public x0() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.play.core.internal.r1
    protected final boolean x0(int i2, Parcel parcel) throws RemoteException {
        switch (i2) {
            case 2:
                w0(parcel.readInt(), (Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) s1.a(parcel, Bundle.CREATOR);
                a(readInt);
                return true;
            case 4:
                i(parcel.readInt(), (Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                h0(parcel.readInt(), (Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                j0((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                j((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                a((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) s1.a(parcel, Bundle.CREATOR);
                b();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) s1.a(parcel, Bundle.CREATOR);
                a();
                return true;
            case 12:
                c((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                b((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
