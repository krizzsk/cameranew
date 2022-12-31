package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zztg implements Parcelable.Creator<zzth> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzth createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Bundle bundle = null;
        String str5 = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 4:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 10:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 11:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzth(str, j2, str2, str3, str4, bundle, z, j3, str5, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzth[] newArray(int i2) {
        return new zzth[i2];
    }
}
