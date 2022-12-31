package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaq createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                bundle = SafeParcelReader.f(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaq(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzaq[] newArray(int i2) {
        return new zzaq[i2];
    }
}
