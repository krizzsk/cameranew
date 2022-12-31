package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajs implements Parcelable.Creator<zzajt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajt createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                i4 = SafeParcelReader.F(parcel, D);
            } else if (v != 1000) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzajt(i2, i3, str, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajt[] newArray(int i2) {
        return new zzajt[i2];
    }
}
