package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdpj implements Parcelable.Creator<zzdpf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdpf createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 3:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    i6 = SafeParcelReader.F(parcel, D);
                    break;
                case 7:
                    i7 = SafeParcelReader.F(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzdpf(i2, i3, i4, i5, str, i6, i7);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzdpf[] newArray(int i2) {
        return new zzdpf[i2];
    }
}
