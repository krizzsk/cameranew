package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzatc implements Parcelable.Creator<zzatd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatd createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        ArrayList<String> arrayList3 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        zzatp zzatpVar = null;
        String str7 = null;
        String str8 = null;
        zzavj zzavjVar = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        zzatf zzatfVar = null;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        String str10 = null;
        zzawu zzawuVar = null;
        String str11 = null;
        Bundle bundle = null;
        ArrayList<String> arrayList7 = null;
        String str12 = null;
        String str13 = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        int i5 = 0;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 5:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    arrayList2 = SafeParcelReader.r(parcel, D);
                    break;
                case 7:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 10:
                    arrayList3 = SafeParcelReader.r(parcel, D);
                    break;
                case 11:
                    j4 = SafeParcelReader.I(parcel, D);
                    break;
                case 12:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 14:
                    j5 = SafeParcelReader.I(parcel, D);
                    break;
                case 15:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 16:
                case 17:
                case 20:
                case 27:
                case 38:
                case 41:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 18:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 19:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 21:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
                case 22:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 23:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 24:
                    z5 = SafeParcelReader.w(parcel, D);
                    break;
                case 25:
                    z6 = SafeParcelReader.w(parcel, D);
                    break;
                case 26:
                    z7 = SafeParcelReader.w(parcel, D);
                    break;
                case 28:
                    zzatpVar = (zzatp) SafeParcelReader.o(parcel, D, zzatp.CREATOR);
                    break;
                case 29:
                    str7 = SafeParcelReader.p(parcel, D);
                    break;
                case 30:
                    str8 = SafeParcelReader.p(parcel, D);
                    break;
                case 31:
                    z8 = SafeParcelReader.w(parcel, D);
                    break;
                case 32:
                    z9 = SafeParcelReader.w(parcel, D);
                    break;
                case 33:
                    zzavjVar = (zzavj) SafeParcelReader.o(parcel, D, zzavj.CREATOR);
                    break;
                case 34:
                    arrayList4 = SafeParcelReader.r(parcel, D);
                    break;
                case 35:
                    arrayList5 = SafeParcelReader.r(parcel, D);
                    break;
                case 36:
                    z10 = SafeParcelReader.w(parcel, D);
                    break;
                case 37:
                    zzatfVar = (zzatf) SafeParcelReader.o(parcel, D, zzatf.CREATOR);
                    break;
                case 39:
                    str9 = SafeParcelReader.p(parcel, D);
                    break;
                case 40:
                    arrayList6 = SafeParcelReader.r(parcel, D);
                    break;
                case 42:
                    z11 = SafeParcelReader.w(parcel, D);
                    break;
                case 43:
                    str10 = SafeParcelReader.p(parcel, D);
                    break;
                case 44:
                    zzawuVar = (zzawu) SafeParcelReader.o(parcel, D, zzawu.CREATOR);
                    break;
                case 45:
                    str11 = SafeParcelReader.p(parcel, D);
                    break;
                case 46:
                    z12 = SafeParcelReader.w(parcel, D);
                    break;
                case 47:
                    z13 = SafeParcelReader.w(parcel, D);
                    break;
                case 48:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 49:
                    z14 = SafeParcelReader.w(parcel, D);
                    break;
                case 50:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 51:
                    z15 = SafeParcelReader.w(parcel, D);
                    break;
                case 52:
                    arrayList7 = SafeParcelReader.r(parcel, D);
                    break;
                case 53:
                    z16 = SafeParcelReader.w(parcel, D);
                    break;
                case 54:
                    str12 = SafeParcelReader.p(parcel, D);
                    break;
                case 55:
                    str13 = SafeParcelReader.p(parcel, D);
                    break;
                case 56:
                    z17 = SafeParcelReader.w(parcel, D);
                    break;
                case 57:
                    z18 = SafeParcelReader.w(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzatd(i2, str, str2, arrayList, i3, arrayList2, j2, z, j3, arrayList3, j4, i4, str3, j5, str4, z2, str5, str6, z3, z4, z5, z6, z7, zzatpVar, str7, str8, z8, z9, zzavjVar, arrayList4, arrayList5, z10, zzatfVar, str9, arrayList6, z11, str10, zzawuVar, str11, z12, z13, bundle, z14, i5, z15, arrayList7, z16, str12, str13, z17, z18);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatd[] newArray(int i2) {
        return new zzatd[i2];
    }
}
