package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<StringToIntConverter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList = SafeParcelReader.t(parcel, D, StringToIntConverter.zaa.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new StringToIntConverter(i2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter[] newArray(int i2) {
        return new StringToIntConverter[i2];
    }
}
