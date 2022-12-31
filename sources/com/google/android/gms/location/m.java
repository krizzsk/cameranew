package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<LocationSettingsRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        ArrayList arrayList = null;
        zzae zzaeVar = null;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.t(parcel, D, LocationRequest.CREATOR);
            } else if (v == 2) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v == 3) {
                z2 = SafeParcelReader.w(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                zzaeVar = (zzae) SafeParcelReader.o(parcel, D, zzae.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new LocationSettingsRequest(arrayList, z, z2, zzaeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ LocationSettingsRequest[] newArray(int i2) {
        return new LocationSettingsRequest[i2];
    }
}
