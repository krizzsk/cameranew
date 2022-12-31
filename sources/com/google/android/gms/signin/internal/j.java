package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, D, ConnectionResult.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.o(parcel, D, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zam(i2, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i2) {
        return new zam[i2];
    }
}
