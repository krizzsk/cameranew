package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class u0 implements Parcelable.Creator<zzv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                i2 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzv(i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzv[] newArray(int i2) {
        return new zzv[i2];
    }
}
