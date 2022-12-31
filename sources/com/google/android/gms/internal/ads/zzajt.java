package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzajt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajt> CREATOR = new zzajs();
    public final int versionCode;
    public final int zzbnt;
    public final int zzdiz;
    public final String zzdja;

    public zzajt(zzakf zzakfVar) {
        this(2, 1, zzakfVar.zzuh(), zzakfVar.getMediaAspectRatio());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.zzdiz);
        a.v(parcel, 2, this.zzdja, false);
        a.m(parcel, 3, this.zzbnt);
        a.m(parcel, 1000, this.versionCode);
        a.b(parcel, a);
    }

    public zzajt(int i2, int i3, String str, int i4) {
        this.versionCode = i2;
        this.zzdiz = i3;
        this.zzdja = str;
        this.zzbnt = i4;
    }
}
