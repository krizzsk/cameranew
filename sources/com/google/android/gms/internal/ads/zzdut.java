package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdut implements Parcelable.Creator<zzduu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzduu createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 4) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                i4 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzduu(i2, i3, i4, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzduu[] newArray(int i2) {
        return new zzduu[i2];
    }
}
