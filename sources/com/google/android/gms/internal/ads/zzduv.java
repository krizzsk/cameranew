package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduv implements Parcelable.Creator<zzduw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzduw createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        byte[] bArr = null;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                bArr = SafeParcelReader.g(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                i3 = SafeParcelReader.F(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzduw(i2, bArr, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzduw[] newArray(int i2) {
        return new zzduw[i2];
    }
}
