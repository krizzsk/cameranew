package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class b0 implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v == 3) {
                i4 = SafeParcelReader.F(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.s(parcel, D, Scope.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new SignInButtonConfig(i2, i3, i4, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }
}
