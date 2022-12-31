package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzj implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f2 = 0.0f;
        int i2 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 3:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 6:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 7:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 8:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    z5 = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    z6 = SafeParcelReader.w(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzk(z, z2, str, z3, f2, i2, z4, z5, z6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i2) {
        return new zzk[i2];
    }
}
