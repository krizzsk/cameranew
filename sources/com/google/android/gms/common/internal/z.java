package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class z implements Parcelable.Creator<ResolveAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                i2 = SafeParcelReader.F(parcel, D);
            } else if (v == 2) {
                account = (Account) SafeParcelReader.o(parcel, D, Account.CREATOR);
            } else if (v == 3) {
                i3 = SafeParcelReader.F(parcel, D);
            } else if (v != 4) {
                SafeParcelReader.M(parcel, D);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.o(parcel, D, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new ResolveAccountRequest(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest[] newArray(int i2) {
        return new ResolveAccountRequest[i2];
    }
}
