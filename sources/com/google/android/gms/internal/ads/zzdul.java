package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdul implements Parcelable.Creator<zzdum> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdum createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                bArr = SafeParcelReader.g(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzdum(i2, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdum[] newArray(int i2) {
        return new zzdum[i2];
    }
}
