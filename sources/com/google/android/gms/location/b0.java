package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b0 implements Parcelable.Creator<GeofencingRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        int i2 = 0;
        String str = "";
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.t(parcel, D, zzbh.CREATOR);
            } else if (v == 2) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GeofencingRequest(arrayList, i2, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GeofencingRequest[] newArray(int i2) {
        return new GeofencingRequest[i2];
    }
}
