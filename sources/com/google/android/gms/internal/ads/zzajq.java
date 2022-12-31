package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajq implements Parcelable.Creator<zzajr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajr createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        Bundle bundle = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                bundle = SafeParcelReader.f(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzajr(str, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajr[] newArray(int i2) {
        return new zzajr[i2];
    }
}
