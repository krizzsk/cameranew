package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzava extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzava> CREATOR = new zzavd();
    public final String zzbut;
    public final zzvl zzdud;

    public zzava(zzvl zzvlVar, String str) {
        this.zzdud = zzvlVar;
        this.zzbut = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.t(parcel, 2, this.zzdud, i2, false);
        a.v(parcel, 3, this.zzbut, false);
        a.b(parcel, a);
    }
}
