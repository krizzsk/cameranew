package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzavd implements Parcelable.Creator<zzava> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzava createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        zzvl zzvlVar = null;
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                zzvlVar = (zzvl) SafeParcelReader.o(parcel, D, zzvl.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzava(zzvlVar, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzava[] newArray(int i2) {
        return new zzava[i2];
    }
}
