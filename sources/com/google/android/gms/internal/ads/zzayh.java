package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzayh implements Parcelable.Creator<zzaye> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaye createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        zzvs zzvsVar = null;
        zzvl zzvlVar = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                zzvsVar = (zzvs) SafeParcelReader.o(parcel, D, zzvs.CREATOR);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                zzvlVar = (zzvl) SafeParcelReader.o(parcel, D, zzvl.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaye(str, str2, zzvsVar, zzvlVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaye[] newArray(int i2) {
        return new zzaye[i2];
    }
}
