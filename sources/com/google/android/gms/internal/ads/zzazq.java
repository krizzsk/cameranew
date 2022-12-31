package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazq implements Parcelable.Creator<zzazn> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazn createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 4) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 5) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v != 6) {
                SafeParcelReader.M(parcel, D);
            } else {
                z2 = SafeParcelReader.w(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzazn(str, i2, i3, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzazn[] newArray(int i2) {
        return new zzazn[i2];
    }
}
