package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzata implements Parcelable.Creator<zzatb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatb createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        Bundle bundle = null;
        zzvl zzvlVar = null;
        zzvs zzvsVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzazn zzaznVar = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzaeh zzaehVar = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzzi zzziVar = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        ArrayList<String> arrayList6 = null;
        String str16 = null;
        zzajt zzajtVar = null;
        String str17 = null;
        Bundle bundle6 = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i8 = 0;
        boolean z5 = false;
        boolean z6 = false;
        int i9 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 3:
                    zzvlVar = (zzvl) SafeParcelReader.o(parcel, D, zzvl.CREATOR);
                    break;
                case 4:
                    zzvsVar = (zzvs) SafeParcelReader.o(parcel, D, zzvs.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.o(parcel, D, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.o(parcel, D, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 9:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 10:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 11:
                    zzaznVar = (zzazn) SafeParcelReader.o(parcel, D, zzazn.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.f(parcel, D);
                    break;
                case 13:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 14:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.f(parcel, D);
                    break;
                case 16:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 38:
                case 62:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 18:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 19:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 20:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 21:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 25:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 26:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
                case 27:
                    arrayList2 = SafeParcelReader.r(parcel, D);
                    break;
                case 28:
                    str7 = SafeParcelReader.p(parcel, D);
                    break;
                case 29:
                    zzaehVar = (zzaeh) SafeParcelReader.o(parcel, D, zzaeh.CREATOR);
                    break;
                case 30:
                    arrayList3 = SafeParcelReader.r(parcel, D);
                    break;
                case 31:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 33:
                    str8 = SafeParcelReader.p(parcel, D);
                    break;
                case 34:
                    f3 = SafeParcelReader.B(parcel, D);
                    break;
                case 35:
                    i6 = SafeParcelReader.F(parcel, D);
                    break;
                case 36:
                    i7 = SafeParcelReader.F(parcel, D);
                    break;
                case 37:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 39:
                    str9 = SafeParcelReader.p(parcel, D);
                    break;
                case 40:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 41:
                    str10 = SafeParcelReader.p(parcel, D);
                    break;
                case 42:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 43:
                    i8 = SafeParcelReader.F(parcel, D);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.f(parcel, D);
                    break;
                case 45:
                    str11 = SafeParcelReader.p(parcel, D);
                    break;
                case 46:
                    zzziVar = (zzzi) SafeParcelReader.o(parcel, D, zzzi.CREATOR);
                    break;
                case 47:
                    z5 = SafeParcelReader.w(parcel, D);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.f(parcel, D);
                    break;
                case 49:
                    str12 = SafeParcelReader.p(parcel, D);
                    break;
                case 50:
                    str13 = SafeParcelReader.p(parcel, D);
                    break;
                case 51:
                    str14 = SafeParcelReader.p(parcel, D);
                    break;
                case 52:
                    z6 = SafeParcelReader.w(parcel, D);
                    break;
                case 53:
                    arrayList4 = SafeParcelReader.k(parcel, D);
                    break;
                case 54:
                    str15 = SafeParcelReader.p(parcel, D);
                    break;
                case 55:
                    arrayList5 = SafeParcelReader.r(parcel, D);
                    break;
                case 56:
                    i9 = SafeParcelReader.F(parcel, D);
                    break;
                case 57:
                    z7 = SafeParcelReader.w(parcel, D);
                    break;
                case 58:
                    z8 = SafeParcelReader.w(parcel, D);
                    break;
                case 59:
                    z9 = SafeParcelReader.w(parcel, D);
                    break;
                case 60:
                    arrayList6 = SafeParcelReader.r(parcel, D);
                    break;
                case 61:
                    str16 = SafeParcelReader.p(parcel, D);
                    break;
                case 63:
                    zzajtVar = (zzajt) SafeParcelReader.o(parcel, D, zzajt.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.p(parcel, D);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.f(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzatb(i2, bundle, zzvlVar, zzvsVar, str, applicationInfo, packageInfo, str2, str3, str4, zzaznVar, bundle2, i3, arrayList, bundle3, z, i4, i5, f2, str5, j2, str6, arrayList2, str7, zzaehVar, arrayList3, j3, str8, f3, z2, i6, i7, z3, str9, str10, z4, i8, bundle4, str11, zzziVar, z5, bundle5, str12, str13, str14, z6, arrayList4, str15, arrayList5, i9, z7, z8, z9, arrayList6, str16, zzajtVar, str17, bundle6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatb[] newArray(int i2) {
        return new zzatb[i2];
    }
}
