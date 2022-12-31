package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzatr implements Parcelable.Creator<zzatp> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatp createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.o(parcel, D, ParcelFileDescriptor.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzatp(parcelFileDescriptor);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatp[] newArray(int i2) {
        return new zzatp[i2];
    }
}
