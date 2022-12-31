package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.t(parcel, D, zzao.CREATOR);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList2 = SafeParcelReader.t(parcel, D, zzan.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzal(arrayList, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i2) {
        return new zzal[i2];
    }
}
