package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes2.dex */
public final class MapStyleOptions extends AbstractSafeParcelable {
    private String zzdl;
    private static final String TAG = MapStyleOptions.class.getSimpleName();
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new j();

    public MapStyleOptions(String str) {
        this.zzdl = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zzdl, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
