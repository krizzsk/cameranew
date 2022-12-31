package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                j2 = SafeParcelReader.I(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new Feature(str, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i2) {
        return new Feature[i2];
    }
}
