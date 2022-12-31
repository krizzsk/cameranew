package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvn implements Parcelable.Creator<zzvl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvl createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzaaq zzaaqVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzve zzveVar = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        long j2 = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 3:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 4:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 5:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 6:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 7:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 8:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 10:
                    zzaaqVar = (zzaaq) SafeParcelReader.o(parcel, D, zzaaq.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.o(parcel, D, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.f(parcel, D);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.f(parcel, D);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.r(parcel, D);
                    break;
                case 16:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 17:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 18:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 19:
                    zzveVar = (zzve) SafeParcelReader.o(parcel, D, zzve.CREATOR);
                    break;
                case 20:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 21:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 22:
                    arrayList3 = SafeParcelReader.r(parcel, D);
                    break;
                case 23:
                    i6 = SafeParcelReader.F(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzvl(i2, j2, bundle, i3, arrayList, z, i4, z2, str, zzaaqVar, location, str2, bundle2, bundle3, arrayList2, str3, str4, z3, zzveVar, i5, str5, arrayList3, i6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzvl[] newArray(int i2) {
        return new zzvl[i2];
    }
}
