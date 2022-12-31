package com.google.android.play.core.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class s1 {
    static {
        s1.class.getClassLoader();
    }

    private s1() {
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface);
    }

    public static void c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
