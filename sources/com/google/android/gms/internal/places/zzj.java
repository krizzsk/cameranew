package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class zzj implements Parcelable.Creator<zzi> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v != 6) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList = SafeParcelReader.t(parcel, D, zzg.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzi(str, str2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzi[] newArray(int i2) {
        return new zzi[i2];
    }
}
