package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<zal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                arrayList = SafeParcelReader.t(parcel, D, zak.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zal(i2, arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal[] newArray(int i2) {
        return new zal[i2];
    }
}
