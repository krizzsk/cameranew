package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* loaded from: classes2.dex */
public final class z implements Parcelable.Creator<DetectedActivity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DetectedActivity createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                i3 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new DetectedActivity(i2, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DetectedActivity[] newArray(int i2) {
        return new DetectedActivity[i2];
    }
}
