package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class a0 implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                iBinder = SafeParcelReader.E(parcel, D);
            } else if (v == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.o(parcel, D, ConnectionResult.CREATOR);
            } else if (v == 4) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v != 5) {
                SafeParcelReader.M(parcel, D);
            } else {
                z2 = SafeParcelReader.w(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new ResolveAccountResponse(i2, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i2) {
        return new ResolveAccountResponse[i2];
    }
}
