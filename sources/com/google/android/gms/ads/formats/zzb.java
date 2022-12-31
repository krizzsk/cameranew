package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzb implements Parcelable.Creator<AdManagerAdViewOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdManagerAdViewOptions createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                z = SafeParcelReader.w(parcel, D);
            } else if (v != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                iBinder = SafeParcelReader.E(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new AdManagerAdViewOptions(z, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AdManagerAdViewOptions[] newArray(int i2) {
        return new AdManagerAdViewOptions[i2];
    }
}
