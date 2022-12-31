package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvg> CREATOR = new zzvf();
    public final int errorCode;
    public final String zzchg;
    public final String zzchh;
    @Nullable
    public zzvg zzchi;
    @Nullable
    public IBinder zzchj;

    public zzvg(int i2, String str, String str2, @Nullable zzvg zzvgVar, @Nullable IBinder iBinder) {
        this.errorCode = i2;
        this.zzchg = str;
        this.zzchh = str2;
        this.zzchi = zzvgVar;
        this.zzchj = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.errorCode);
        a.v(parcel, 2, this.zzchg, false);
        a.v(parcel, 3, this.zzchh, false);
        a.t(parcel, 4, this.zzchi, i2, false);
        a.l(parcel, 5, this.zzchj, false);
        a.b(parcel, a);
    }

    public final AdError zzqb() {
        zzvg zzvgVar = this.zzchi;
        return new AdError(this.errorCode, this.zzchg, this.zzchh, zzvgVar == null ? null : new AdError(zzvgVar.errorCode, zzvgVar.zzchg, zzvgVar.zzchh));
    }

    public final LoadAdError zzqc() {
        zzvg zzvgVar = this.zzchi;
        zzyx zzyxVar = null;
        AdError adError = zzvgVar == null ? null : new AdError(zzvgVar.errorCode, zzvgVar.zzchg, zzvgVar.zzchh);
        int i2 = this.errorCode;
        String str = this.zzchg;
        String str2 = this.zzchh;
        IBinder iBinder = this.zzchj;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzyx) {
                zzyxVar = (zzyx) queryLocalInterface;
            } else {
                zzyxVar = new zzyz(iBinder);
            }
        }
        return new LoadAdError(i2, str, str2, adError, ResponseInfo.zza(zzyxVar));
    }
}
