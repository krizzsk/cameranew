package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        ArrayList arrayList3 = null;
        String str4 = null;
        ArrayList arrayList4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    arrayList = SafeParcelReader.k(parcel, D);
                    break;
                case 4:
                    arrayList2 = SafeParcelReader.t(parcel, D, zzb.CREATOR);
                    break;
                case 5:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 7:
                    arrayList3 = SafeParcelReader.t(parcel, D, zzb.CREATOR);
                    break;
                case 8:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 9:
                    arrayList4 = SafeParcelReader.t(parcel, D, zzb.CREATOR);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzc(str, arrayList, i2, str2, arrayList2, str3, arrayList3, str4, arrayList4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i2) {
        return new zzc[i2];
    }
}
