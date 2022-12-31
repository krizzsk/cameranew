package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzbe implements Parcelable.Creator<zzbd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        List<ClientIdentity> list = zzbd.zzcd;
        LocationRequest locationRequest = null;
        String str = null;
        String str2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v != 1) {
                switch (v) {
                    case 5:
                        list = SafeParcelReader.t(parcel, D, ClientIdentity.CREATOR);
                        continue;
                    case 6:
                        str = SafeParcelReader.p(parcel, D);
                        continue;
                    case 7:
                        z = SafeParcelReader.w(parcel, D);
                        continue;
                    case 8:
                        z2 = SafeParcelReader.w(parcel, D);
                        continue;
                    case 9:
                        z3 = SafeParcelReader.w(parcel, D);
                        continue;
                    case 10:
                        str2 = SafeParcelReader.p(parcel, D);
                        continue;
                    default:
                        SafeParcelReader.M(parcel, D);
                        continue;
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.o(parcel, D, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzbd(locationRequest, list, str, z, z2, z3, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbd[] newArray(int i2) {
        return new zzbd[i2];
    }
}
