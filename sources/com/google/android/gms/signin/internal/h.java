package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<zag> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.r(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zag(arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zag[] newArray(int i2) {
        return new zag[i2];
    }
}
