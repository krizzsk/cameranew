package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzj();
    public final boolean zzbpe;
    public final boolean zzbpf;
    private final String zzbpg;
    public final boolean zzbph;
    public final float zzbpi;
    public final int zzbpj;
    public final boolean zzbpk;
    public final boolean zzbpl;
    public final boolean zzbpm;

    public zzk(boolean z, boolean z2, boolean z3, float f2, int i2, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 2, this.zzbpe);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, this.zzbpf);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.zzbpg, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 5, this.zzbph);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 6, this.zzbpi);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 7, this.zzbpj);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, this.zzbpk);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, this.zzbpl);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 10, this.zzbpm);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(boolean z, boolean z2, String str, boolean z3, float f2, int i2, boolean z4, boolean z5, boolean z6) {
        this.zzbpe = z;
        this.zzbpf = z2;
        this.zzbpg = str;
        this.zzbph = z3;
        this.zzbpi = f2;
        this.zzbpj = i2;
        this.zzbpk = z4;
        this.zzbpl = z5;
        this.zzbpm = z6;
    }
}
