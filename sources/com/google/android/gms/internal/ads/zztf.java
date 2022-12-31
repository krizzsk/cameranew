package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztf implements Parcelable.Creator<zztc> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztc createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        long j2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.o(parcel, D, ParcelFileDescriptor.CREATOR);
            } else if (v == 3) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 4) {
                z2 = SafeParcelReader.w(parcel, D);
            } else if (v == 5) {
                j2 = SafeParcelReader.I(parcel, D);
            } else if (v != 6) {
                SafeParcelReader.M(parcel, D);
            } else {
                z3 = SafeParcelReader.w(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zztc(parcelFileDescriptor, z, z2, j2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zztc[] newArray(int i2) {
        return new zztc[i2];
    }
}
