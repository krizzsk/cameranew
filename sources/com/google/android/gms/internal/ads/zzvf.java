package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvf implements Parcelable.Creator<zzvg> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvg createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        zzvg zzvgVar = null;
        IBinder iBinder = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v == 3) {
                str2 = SafeParcelReader.p(parcel, D);
            } else if (v == 4) {
                zzvgVar = (zzvg) SafeParcelReader.o(parcel, D, zzvg.CREATOR);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                iBinder = SafeParcelReader.E(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzvg(i2, str, str2, zzvgVar, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvg[] newArray(int i2) {
        return new zzvg[i2];
    }
}
