package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<zan> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zan createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        FastJsonResponse.Field field = null;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                field = (FastJsonResponse.Field) SafeParcelReader.o(parcel, D, FastJsonResponse.Field.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zan(i2, str, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zan[] newArray(int i2) {
        return new zan[i2];
    }
}
