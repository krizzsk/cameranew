package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<zzai> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzai createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList<Integer> arrayList = null;
        String str = null;
        Uri uri = null;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.k(parcel, D);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                uri = (Uri) SafeParcelReader.o(parcel, D, Uri.CREATOR);
            } else if (v == 4) {
                f2 = SafeParcelReader.B(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzai(arrayList, str, uri, f2, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzai[] newArray(int i2) {
        return new zzai[i2];
    }
}
