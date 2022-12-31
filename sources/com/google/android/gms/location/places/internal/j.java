package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<zzan> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzan createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 3:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    i6 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    i7 = SafeParcelReader.F(parcel, D);
                    break;
                case 7:
                    arrayList = SafeParcelReader.t(parcel, D, zzao.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzan(i2, i3, i4, i5, i6, i7, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzan[] newArray(int i2) {
        return new zzan[i2];
    }
}
