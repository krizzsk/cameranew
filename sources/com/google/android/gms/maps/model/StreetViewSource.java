package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class StreetViewSource extends AbstractSafeParcelable {
    private final int type;
    private static final String TAG = StreetViewSource.class.getSimpleName();
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new t();
    public static final StreetViewSource DEFAULT = new StreetViewSource(0);
    public static final StreetViewSource OUTDOOR = new StreetViewSource(1);

    public StreetViewSource(int i2) {
        this.type = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.type == ((StreetViewSource) obj).type;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.p.b(Integer.valueOf(this.type));
    }

    public final String toString() {
        int i2 = this.type;
        return String.format("StreetViewSource:%s", i2 != 0 ? i2 != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i2)) : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.type);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
