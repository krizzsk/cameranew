package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.b;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zza();
    public final Intent intent;
    public final String mimeType;
    public final String packageName;
    public final String url;
    public final zzt zzdif;
    private final String zzdsc;
    public final String zzdsd;
    public final String zzdse;
    private final String zzdsf;
    public final boolean zzdsg;

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7, zzt zztVar) {
        this(str, str2, str3, str4, str5, str6, str7, null, com.google.android.gms.dynamic.d.z0(zztVar).asBinder(), false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.zzdsc, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.url, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, this.mimeType, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 5, this.packageName, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 6, this.zzdsd, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, this.zzdse, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 8, this.zzdsf, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 9, this.intent, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 10, com.google.android.gms.dynamic.d.z0(this.zzdif).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 11, this.zzdsg);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public zzd(Intent intent, zzt zztVar) {
        this(null, null, null, null, null, null, null, intent, com.google.android.gms.dynamic.d.z0(zztVar).asBinder(), false);
    }

    public zzd(String str, zzt zztVar, boolean z) {
        this(null, str, null, null, null, null, null, null, com.google.android.gms.dynamic.d.z0(zztVar).asBinder(), true);
    }

    public zzd(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent, IBinder iBinder, boolean z) {
        this.zzdsc = str;
        this.url = str2;
        this.mimeType = str3;
        this.packageName = str4;
        this.zzdsd = str5;
        this.zzdse = str6;
        this.zzdsf = str7;
        this.intent = intent;
        this.zzdif = (zzt) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder));
        this.zzdsg = z;
    }
}
