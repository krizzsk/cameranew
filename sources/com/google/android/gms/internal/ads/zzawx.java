package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzawx implements Parcelable.Creator<zzawu> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawu createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
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
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 5:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 7:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 8:
                    z4 = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.r(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzawu(str, str2, z, z2, arrayList, z3, z4, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzawu[] newArray(int i2) {
        return new zzawu[i2];
    }
}
