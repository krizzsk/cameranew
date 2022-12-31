package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvw> CREATOR = new zzvv();
    public String zzcio;
    public long zzcip;
    @Nullable
    public zzvg zzciq;
    public Bundle zzcir;

    public zzvw(String str, long j2, @Nullable zzvg zzvgVar, Bundle bundle) {
        this.zzcio = str;
        this.zzcip = j2;
        this.zzciq = zzvgVar;
        this.zzcir = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzcio, false);
        a.q(parcel, 2, this.zzcip);
        a.t(parcel, 3, this.zzciq, i2, false);
        a.e(parcel, 4, this.zzcir, false);
        a.b(parcel, a);
    }
}
