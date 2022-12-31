package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvv implements Parcelable.Creator<zzvw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvw createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        zzvg zzvgVar = null;
        Bundle bundle = null;
        long j2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 2) {
                j2 = SafeParcelReader.I(parcel, D);
            } else if (v == 3) {
                zzvgVar = (zzvg) SafeParcelReader.o(parcel, D, zzvg.CREATOR);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                bundle = SafeParcelReader.f(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzvw(str, j2, zzvgVar, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvw[] newArray(int i2) {
        return new zzvw[i2];
    }
}
