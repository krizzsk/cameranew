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
public final class zzatt implements Parcelable.Creator<zzatq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatq createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Bundle bundle = null;
        zzazn zzaznVar = null;
        ApplicationInfo applicationInfo = null;
        String str = null;
        ArrayList<String> arrayList = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        zzdpf zzdpfVar = null;
        String str4 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 2:
                    zzaznVar = (zzazn) SafeParcelReader.o(parcel, D, zzazn.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.o(parcel, D, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.o(parcel, D, PackageInfo.CREATOR);
                    break;
                case 7:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 9:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 10:
                    zzdpfVar = (zzdpf) SafeParcelReader.o(parcel, D, zzdpf.CREATOR);
                    break;
                case 11:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzatq(bundle, zzaznVar, applicationInfo, str, arrayList, packageInfo, str2, str3, zzdpfVar, str4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatq[] newArray(int i2) {
        return new zzatq[i2];
    }
}
