package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes2.dex */
public class zzh {
    private static final ClassLoader zza = zzh.class.getClassLoader();

    private zzh() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
