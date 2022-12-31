package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<GoogleSignInOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        ArrayList arrayList2 = null;
        String str3 = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    arrayList = SafeParcelReader.t(parcel, D, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) SafeParcelReader.o(parcel, D, Account.CREATOR);
                    break;
                case 4:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 5:
                    z2 = SafeParcelReader.w(parcel, D);
                    break;
                case 6:
                    z3 = SafeParcelReader.w(parcel, D);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.t(parcel, D, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GoogleSignInOptions(i2, arrayList, account, z, z2, z3, str, str2, arrayList2, str3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInOptions[] newArray(int i2) {
        return new GoogleSignInOptions[i2];
    }
}
