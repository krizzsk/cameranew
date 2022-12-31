package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaat implements Parcelable.Creator<zzaaq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaaq createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 15) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaaq(str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaaq[] newArray(int i2) {
        return new zzaaq[i2];
    }
}
