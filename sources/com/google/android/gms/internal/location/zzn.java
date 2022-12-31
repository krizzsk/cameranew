package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzn implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        com.google.android.gms.location.zzj zzjVar = zzm.zzce;
        List<ClientIdentity> list = zzm.zzcd;
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                zzjVar = (com.google.android.gms.location.zzj) SafeParcelReader.o(parcel, D, com.google.android.gms.location.zzj.CREATOR);
            } else if (v == 2) {
                list = SafeParcelReader.t(parcel, D, ClientIdentity.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzm(zzjVar, list, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i2) {
        return new zzm[i2];
    }
}
