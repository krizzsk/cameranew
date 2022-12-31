package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvt implements Parcelable.Creator<zzvu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvu createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                j2 = SafeParcelReader.I(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzvu(i2, i3, str, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvu[] newArray(int i2) {
        return new zzvu[i2];
    }
}
