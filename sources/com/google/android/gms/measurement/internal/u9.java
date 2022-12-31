package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class u9 implements Parcelable.Creator<zzp> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzp createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        String str9 = "";
        long j7 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 7:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 8:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 9:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 10:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 11:
                    j7 = SafeParcelReader.I(parcel, D);
                    break;
                case 12:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
                case 13:
                    j4 = SafeParcelReader.I(parcel, D);
                    break;
                case 14:
                    j5 = SafeParcelReader.I(parcel, D);
                    break;
                case 15:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 16:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 18:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 19:
                    str7 = SafeParcelReader.p(parcel, D);
                    break;
                case 21:
                    bool = SafeParcelReader.x(parcel, D);
                    break;
                case 22:
                    j6 = SafeParcelReader.I(parcel, D);
                    break;
                case 23:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 24:
                    str8 = SafeParcelReader.p(parcel, D);
                    break;
                case 25:
                    str9 = SafeParcelReader.p(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzp(str, str2, str3, str4, j2, j3, str5, z, z2, j7, str6, j4, j5, i2, z3, z4, str7, bool, j6, arrayList, str8, str9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzp[] newArray(int i2) {
        return new zzp[i2];
    }
}
