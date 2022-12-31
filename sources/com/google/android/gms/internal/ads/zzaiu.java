package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaiu implements Parcelable.Creator<zzaiv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiv createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j2 = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    bArr = SafeParcelReader.g(parcel, D);
                    break;
                case 5:
                    strArr = SafeParcelReader.q(parcel, D);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.q(parcel, D);
                    break;
                case 7:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 8:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzaiv(z, str, i2, bArr, strArr, strArr2, z2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaiv[] newArray(int i2) {
        return new zzaiv[i2];
    }
}
