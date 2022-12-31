package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.ads.zzazn;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzo implements Parcelable.Creator<AdOverlayInfoParcel> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        zzd zzdVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        String str2 = null;
        IBinder iBinder5 = null;
        String str3 = null;
        zzazn zzaznVar = null;
        String str4 = null;
        zzk zzkVar = null;
        IBinder iBinder6 = null;
        String str5 = null;
        IBinder iBinder7 = null;
        IBinder iBinder8 = null;
        IBinder iBinder9 = null;
        IBinder iBinder10 = null;
        String str6 = null;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 2:
                    zzdVar = (zzd) SafeParcelReader.o(parcel, D, zzd.CREATOR);
                    break;
                case 3:
                    iBinder = SafeParcelReader.E(parcel, D);
                    break;
                case 4:
                    iBinder2 = SafeParcelReader.E(parcel, D);
                    break;
                case 5:
                    iBinder3 = SafeParcelReader.E(parcel, D);
                    break;
                case 6:
                    iBinder4 = SafeParcelReader.E(parcel, D);
                    break;
                case 7:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 8:
                    z = SafeParcelReader.w(parcel, D);
                    break;
                case 9:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 10:
                    iBinder5 = SafeParcelReader.E(parcel, D);
                    break;
                case 11:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 12:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 13:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 14:
                    zzaznVar = (zzazn) SafeParcelReader.o(parcel, D, zzazn.CREATOR);
                    break;
                case 15:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 16:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 17:
                    zzkVar = (zzk) SafeParcelReader.o(parcel, D, zzk.CREATOR);
                    break;
                case 18:
                    iBinder6 = SafeParcelReader.E(parcel, D);
                    break;
                case 19:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 20:
                    iBinder7 = SafeParcelReader.E(parcel, D);
                    break;
                case 21:
                    iBinder8 = SafeParcelReader.E(parcel, D);
                    break;
                case 22:
                    iBinder9 = SafeParcelReader.E(parcel, D);
                    break;
                case 23:
                    iBinder10 = SafeParcelReader.E(parcel, D);
                    break;
                case 24:
                    str6 = SafeParcelReader.p(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new AdOverlayInfoParcel(zzdVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, zzaznVar, str4, zzkVar, iBinder6, str5, iBinder7, iBinder8, iBinder9, iBinder10, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdOverlayInfoParcel[] newArray(int i2) {
        return new AdOverlayInfoParcel[i2];
    }
}
