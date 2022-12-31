package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzajh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajh> CREATOR = new zzajg();
    public final String description;
    public final String zzdit;
    public final boolean zzdiu;
    public final int zzdiv;

    public zzajh(String str, boolean z, int i2, String str2) {
        this.zzdit = str;
        this.zzdiu = z;
        this.zzdiv = i2;
        this.description = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzdit, false);
        a.c(parcel, 2, this.zzdiu);
        a.m(parcel, 3, this.zzdiv);
        a.v(parcel, 4, this.description, false);
        a.b(parcel, a);
    }
}
