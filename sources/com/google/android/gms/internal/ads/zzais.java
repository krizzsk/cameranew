package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzais implements Parcelable.Creator<zzait> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String[] strArr = null;
        String[] strArr2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                strArr = SafeParcelReader.q(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                strArr2 = SafeParcelReader.q(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzait(str, strArr, strArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzait[] newArray(int i2) {
        return new zzait[i2];
    }
}
