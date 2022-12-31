package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzvl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvl> CREATOR = new zzvn();
    public final Bundle extras;
    public final int versionCode;
    public final int zzado;
    public final int zzadp;
    @Nullable
    public final String zzadq;
    public final boolean zzbni;
    @Deprecated
    public final long zzchn;
    @Deprecated
    public final int zzcho;
    public final List<String> zzchp;
    public final boolean zzchq;
    public final String zzchr;
    public final zzaaq zzchs;
    public final String zzcht;
    public final Bundle zzchu;
    public final Bundle zzchv;
    public final List<String> zzchw;
    public final String zzchx;
    public final String zzchy;
    @Deprecated
    public final boolean zzchz;
    @Nullable
    public final zzve zzcia;
    public final List<String> zzcib;
    public final int zzcic;
    public final Location zznb;

    public zzvl(int i2, long j2, Bundle bundle, int i3, List<String> list, boolean z, int i4, boolean z2, String str, zzaaq zzaaqVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3, zzve zzveVar, int i5, @Nullable String str5, List<String> list3, int i6) {
        this.versionCode = i2;
        this.zzchn = j2;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcho = i3;
        this.zzchp = list;
        this.zzchq = z;
        this.zzado = i4;
        this.zzbni = z2;
        this.zzchr = str;
        this.zzchs = zzaaqVar;
        this.zznb = location;
        this.zzcht = str2;
        this.zzchu = bundle2 == null ? new Bundle() : bundle2;
        this.zzchv = bundle3;
        this.zzchw = list2;
        this.zzchx = str3;
        this.zzchy = str4;
        this.zzchz = z3;
        this.zzcia = zzveVar;
        this.zzadp = i5;
        this.zzadq = str5;
        this.zzcib = list3 == null ? new ArrayList<>() : list3;
        this.zzcic = i6;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzvl) {
            zzvl zzvlVar = (zzvl) obj;
            return this.versionCode == zzvlVar.versionCode && this.zzchn == zzvlVar.zzchn && p.a(this.extras, zzvlVar.extras) && this.zzcho == zzvlVar.zzcho && p.a(this.zzchp, zzvlVar.zzchp) && this.zzchq == zzvlVar.zzchq && this.zzado == zzvlVar.zzado && this.zzbni == zzvlVar.zzbni && p.a(this.zzchr, zzvlVar.zzchr) && p.a(this.zzchs, zzvlVar.zzchs) && p.a(this.zznb, zzvlVar.zznb) && p.a(this.zzcht, zzvlVar.zzcht) && p.a(this.zzchu, zzvlVar.zzchu) && p.a(this.zzchv, zzvlVar.zzchv) && p.a(this.zzchw, zzvlVar.zzchw) && p.a(this.zzchx, zzvlVar.zzchx) && p.a(this.zzchy, zzvlVar.zzchy) && this.zzchz == zzvlVar.zzchz && this.zzadp == zzvlVar.zzadp && p.a(this.zzadq, zzvlVar.zzadq) && p.a(this.zzcib, zzvlVar.zzcib) && this.zzcic == zzvlVar.zzcic;
        }
        return false;
    }

    public final int hashCode() {
        return p.b(Integer.valueOf(this.versionCode), Long.valueOf(this.zzchn), this.extras, Integer.valueOf(this.zzcho), this.zzchp, Boolean.valueOf(this.zzchq), Integer.valueOf(this.zzado), Boolean.valueOf(this.zzbni), this.zzchr, this.zzchs, this.zznb, this.zzcht, this.zzchu, this.zzchv, this.zzchw, this.zzchx, this.zzchy, Boolean.valueOf(this.zzchz), Integer.valueOf(this.zzadp), this.zzadq, this.zzcib, Integer.valueOf(this.zzcic));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.q(parcel, 2, this.zzchn);
        a.e(parcel, 3, this.extras, false);
        a.m(parcel, 4, this.zzcho);
        a.x(parcel, 5, this.zzchp, false);
        a.c(parcel, 6, this.zzchq);
        a.m(parcel, 7, this.zzado);
        a.c(parcel, 8, this.zzbni);
        a.v(parcel, 9, this.zzchr, false);
        a.t(parcel, 10, this.zzchs, i2, false);
        a.t(parcel, 11, this.zznb, i2, false);
        a.v(parcel, 12, this.zzcht, false);
        a.e(parcel, 13, this.zzchu, false);
        a.e(parcel, 14, this.zzchv, false);
        a.x(parcel, 15, this.zzchw, false);
        a.v(parcel, 16, this.zzchx, false);
        a.v(parcel, 17, this.zzchy, false);
        a.c(parcel, 18, this.zzchz);
        a.t(parcel, 19, this.zzcia, i2, false);
        a.m(parcel, 20, this.zzadp);
        a.v(parcel, 21, this.zzadq, false);
        a.x(parcel, 22, this.zzcib, false);
        a.m(parcel, 23, this.zzcic);
        a.b(parcel, a);
    }
}
