package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new i();
    private static final List<zzb> zzbb = Collections.emptyList();
    private final String placeId;
    private final String zzbc;
    private final List<zzb> zzbd;
    private final int zzbe;
    private final String zzbf;
    private final List<zzb> zzbg;
    private final String zzbh;
    private final List<zzb> zzbi;
    private final List<Integer> zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(String str, List<Integer> list, int i2, String str2, List<zzb> list2, String str3, List<zzb> list3, String str4, List<zzb> list4) {
        this.placeId = str;
        this.zzg = list;
        this.zzbe = i2;
        this.zzbc = str2;
        this.zzbd = list2;
        this.zzbf = str3;
        this.zzbg = list3;
        this.zzbh = str4;
        this.zzbi = list4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            return p.a(this.placeId, zzcVar.placeId) && p.a(this.zzg, zzcVar.zzg) && p.a(Integer.valueOf(this.zzbe), Integer.valueOf(zzcVar.zzbe)) && p.a(this.zzbc, zzcVar.zzbc) && p.a(this.zzbd, zzcVar.zzbd) && p.a(this.zzbf, zzcVar.zzbf) && p.a(this.zzbg, zzcVar.zzbg) && p.a(this.zzbh, zzcVar.zzbh) && p.a(this.zzbi, zzcVar.zzbi);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.placeId, this.zzg, Integer.valueOf(this.zzbe), this.zzbc, this.zzbd, this.zzbf, this.zzbg, this.zzbh, this.zzbi);
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("placeId", this.placeId);
        c.a("placeTypes", this.zzg);
        c.a("fullText", this.zzbc);
        c.a("fullTextMatchedSubstrings", this.zzbd);
        c.a("primaryText", this.zzbf);
        c.a("primaryTextMatchedSubstrings", this.zzbg);
        c.a("secondaryText", this.zzbh);
        c.a("secondaryTextMatchedSubstrings", this.zzbi);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, this.zzbc, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.placeId, false);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 3, this.zzg, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 4, this.zzbd, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 5, this.zzbe);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 6, this.zzbf, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 7, this.zzbg, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 8, this.zzbh, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 9, this.zzbi, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
