package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class e0 implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 3:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    iBinder = SafeParcelReader.E(parcel, D);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.s(parcel, D, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, D);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.o(parcel, D, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.s(parcel, D, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.s(parcel, D, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 13:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
