package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public abstract class w1 extends r1 implements x1 {
    public w1() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // com.google.android.play.core.internal.r1
    protected final boolean x0(int i2, Parcel parcel) throws RemoteException {
        switch (i2) {
            case 2:
                i(parcel.readInt(), (Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) s1.a(parcel, Bundle.CREATOR);
                a(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) s1.a(parcel, Bundle.CREATOR);
                b(readInt2);
                return true;
            case 5:
                a(parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle bundle3 = (Bundle) s1.a(parcel, creator);
                c((Bundle) s1.a(parcel, creator));
                return true;
            case 7:
                a((Bundle) s1.a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                Bundle bundle4 = (Bundle) s1.a(parcel, creator2);
                b((Bundle) s1.a(parcel, creator2));
                return true;
            case 9:
            default:
                return false;
            case 10:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle bundle5 = (Bundle) s1.a(parcel, creator3);
                j((Bundle) s1.a(parcel, creator3));
                return true;
            case 11:
                Parcelable.Creator creator4 = Bundle.CREATOR;
                e((Bundle) s1.a(parcel, creator4), (Bundle) s1.a(parcel, creator4));
                return true;
            case 12:
                Parcelable.Creator creator5 = Bundle.CREATOR;
                r((Bundle) s1.a(parcel, creator5), (Bundle) s1.a(parcel, creator5));
                return true;
            case 13:
                Parcelable.Creator creator6 = Bundle.CREATOR;
                i0((Bundle) s1.a(parcel, creator6), (Bundle) s1.a(parcel, creator6));
                return true;
            case 14:
                Parcelable.Creator creator7 = Bundle.CREATOR;
                Bundle bundle6 = (Bundle) s1.a(parcel, creator7);
                Bundle bundle7 = (Bundle) s1.a(parcel, creator7);
                b();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) s1.a(parcel, Bundle.CREATOR);
                a();
                return true;
        }
    }
}
