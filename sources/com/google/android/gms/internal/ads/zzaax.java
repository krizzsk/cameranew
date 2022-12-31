package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaax implements Parcelable.Creator<zzaau> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaau createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 3) {
                z2 = SafeParcelReader.w(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                z3 = SafeParcelReader.w(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaau(z, z2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaau[] newArray(int i2) {
        return new zzaau[i2];
    }
}
