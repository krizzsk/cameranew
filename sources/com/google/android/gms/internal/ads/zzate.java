package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzate implements Parcelable.Creator<zzatf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatf createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 2) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList = SafeParcelReader.r(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzatf(z, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzatf[] newArray(int i2) {
        return new zzatf[i2];
    }
}
