package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zza implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Intent intent = null;
        IBinder iBinder = null;
        boolean z = false;
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
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 6:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 7:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    str7 = SafeParcelReader.p(parcel, D);
                    break;
                case 9:
                    intent = (Intent) SafeParcelReader.o(parcel, D, Intent.CREATOR);
                    break;
                case 10:
                    iBinder = SafeParcelReader.E(parcel, D);
                    break;
                case 11:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzd(str, str2, str3, str4, str5, str6, str7, intent, iBinder, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i2) {
        return new zzd[i2];
    }
}
