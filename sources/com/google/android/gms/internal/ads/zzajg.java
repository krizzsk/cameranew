package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajg implements Parcelable.Creator<zzajh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajh createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 3) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                str2 = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzajh(str, z, i2, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajh[] newArray(int i2) {
        return new zzajh[i2];
    }
}
