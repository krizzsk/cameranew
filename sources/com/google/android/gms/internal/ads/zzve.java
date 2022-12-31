package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new zzvd();
    public final String zzche;
    public final String zzchf;

    public zzve(String str, String str2) {
        this.zzche = str;
        this.zzchf = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzche, false);
        a.v(parcel, 2, this.zzchf, false);
        a.b(parcel, a);
    }
}
