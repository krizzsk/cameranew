package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvr implements Parcelable.Creator<zzvs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvs createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        zzvs[] zzvsVarArr = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 6:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 7:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 8:
                    zzvsVarArr = (zzvs[]) SafeParcelReader.s(parcel, D, zzvs.CREATOR);
                    break;
                case 9:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 11:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 12:
                    z5 = SafeParcelReader.w(parcel, D);
                    break;
                case 13:
                    z6 = SafeParcelReader.w(parcel, D);
                    break;
                case 14:
                    z7 = SafeParcelReader.w(parcel, D);
                    break;
                case 15:
                    z8 = SafeParcelReader.w(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzvs(str, i2, i3, z, i4, i5, zzvsVarArr, z2, z3, z4, z5, z6, z7, z8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvs[] newArray(int i2) {
        return new zzvs[i2];
    }
}
