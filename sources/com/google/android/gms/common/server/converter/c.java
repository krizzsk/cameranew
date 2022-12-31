package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<StringToIntConverter.zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                i3 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new StringToIntConverter.zaa(i2, str, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa[] newArray(int i2) {
        return new StringToIntConverter.zaa[i2];
    }
}
