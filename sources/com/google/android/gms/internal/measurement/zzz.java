package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzz implements Parcelable.Creator<zzy> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzy createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        String str4 = null;
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 2:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 3:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 8:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzy(j2, j3, z, str, str2, str3, bundle, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzy[] newArray(int i2) {
        return new zzy[i2];
    }
}
