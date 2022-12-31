package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzduu> CREATOR = new zzdut();
    private final int versionCode;
    private final String zzhsu;
    private final String zzhsv;
    private final int zzhsw;
    private final int zzhum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzduu(int i2, int i3, int i4, String str, String str2) {
        this.versionCode = i2;
        this.zzhsw = i3;
        this.zzhsu = str;
        this.zzhsv = str2;
        this.zzhum = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.m(parcel, 2, this.zzhsw);
        a.v(parcel, 3, this.zzhsu, false);
        a.v(parcel, 4, this.zzhsv, false);
        a.m(parcel, 5, this.zzhum);
        a.b(parcel, a);
    }

    public zzduu(int i2, zzgp zzgpVar, String str, String str2) {
        this(1, i2, zzgpVar.zzv(), str, str2);
    }
}
