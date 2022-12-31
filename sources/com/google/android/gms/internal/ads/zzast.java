package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzast implements Parcelable.Creator<zzasq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasq createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                iBinder = SafeParcelReader.E(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                iBinder2 = SafeParcelReader.E(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzasq(iBinder, iBinder2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzasq[] newArray(int i2) {
        return new zzasq[i2];
    }
}
