package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 3:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 4:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.o(parcel, D, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 9:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
                case 10:
                    arrayList = SafeParcelReader.t(parcel, D, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.p(parcel, D);
                    break;
                case 12:
                    str8 = SafeParcelReader.p(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
