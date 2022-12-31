package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaiv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaiv> CREATOR = new zzaiu();
    public final byte[] data;
    public final int statusCode;
    public final boolean zzak;
    public final long zzal;
    public final String zzchg;
    public final String[] zzdin;
    public final String[] zzdio;
    public final boolean zzdip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaiv(boolean z, String str, int i2, byte[] bArr, String[] strArr, String[] strArr2, boolean z2, long j2) {
        this.zzdip = z;
        this.zzchg = str;
        this.statusCode = i2;
        this.data = bArr;
        this.zzdin = strArr;
        this.zzdio = strArr2;
        this.zzak = z2;
        this.zzal = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.c(parcel, 1, this.zzdip);
        a.v(parcel, 2, this.zzchg, false);
        a.m(parcel, 3, this.statusCode);
        a.g(parcel, 4, this.data, false);
        a.w(parcel, 5, this.zzdin, false);
        a.w(parcel, 6, this.zzdio, false);
        a.c(parcel, 7, this.zzak);
        a.q(parcel, 8, this.zzal);
        a.b(parcel, a);
    }
}
