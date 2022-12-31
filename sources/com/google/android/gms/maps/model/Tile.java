package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new u();
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i2, int i3, byte[] bArr) {
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.width);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 3, this.height);
        com.google.android.gms.common.internal.safeparcel.a.g(parcel, 4, this.data, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
