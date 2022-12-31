package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.ads.zzahi;
import com.google.android.gms.internal.ads.zzahk;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzbeb;
import com.google.android.gms.internal.ads.zzckn;
import com.google.android.gms.internal.ads.zzcqr;
import com.google.android.gms.internal.ads.zzdrz;
import com.google.android.gms.internal.ads.zzvc;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    public final int orientation;
    public final String url;
    public final zzazn zzbpn;
    public final String zzbvs;
    public final zzvc zzchd;
    public final zzahi zzdgz;
    public final zzahk zzdha;
    public final zzckn zzdib;
    public final zzdrz zzdic;
    public final zzbeb zzdjd;
    public final zzd zzdsu;
    public final zzq zzdsv;
    public final String zzdsw;
    public final boolean zzdsx;
    public final String zzdsy;
    public final zzv zzdsz;
    public final int zzdta;
    public final String zzdtb;
    public final zzk zzdtc;
    public final zzcqr zzdtd;
    public final zzbg zzdte;
    public final String zzdtf;

    public AdOverlayInfoParcel(zzbeb zzbebVar, zzazn zzaznVar, zzbg zzbgVar, zzcqr zzcqrVar, zzckn zzcknVar, zzdrz zzdrzVar, String str, String str2, int i2) {
        this.zzdsu = null;
        this.zzchd = null;
        this.zzdsv = null;
        this.zzdjd = zzbebVar;
        this.zzdgz = null;
        this.zzdha = null;
        this.zzdsw = null;
        this.zzdsx = false;
        this.zzdsy = null;
        this.zzdsz = null;
        this.orientation = i2;
        this.zzdta = 5;
        this.url = null;
        this.zzbpn = zzaznVar;
        this.zzdtb = null;
        this.zzdtc = null;
        this.zzbvs = str;
        this.zzdtf = str2;
        this.zzdtd = zzcqrVar;
        this.zzdib = zzcknVar;
        this.zzdic = zzdrzVar;
        this.zzdte = zzbgVar;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzd(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zzdsu, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 3, com.google.android.gms.dynamic.d.z0(this.zzchd).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 4, com.google.android.gms.dynamic.d.z0(this.zzdsv).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 5, com.google.android.gms.dynamic.d.z0(this.zzdjd).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 6, com.google.android.gms.dynamic.d.z0(this.zzdha).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, this.zzdsw, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 8, this.zzdsx);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 9, this.zzdsy, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 10, com.google.android.gms.dynamic.d.z0(this.zzdsz).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 11, this.orientation);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 12, this.zzdta);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 13, this.url, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 14, this.zzbpn, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 16, this.zzdtb, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 17, this.zzdtc, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 18, com.google.android.gms.dynamic.d.z0(this.zzdgz).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 19, this.zzbvs, false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 20, com.google.android.gms.dynamic.d.z0(this.zzdtd).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 21, com.google.android.gms.dynamic.d.z0(this.zzdib).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 22, com.google.android.gms.dynamic.d.z0(this.zzdic).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.l(parcel, 23, com.google.android.gms.dynamic.d.z0(this.zzdte).asBinder(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 24, this.zzdtf, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public AdOverlayInfoParcel(zzvc zzvcVar, zzq zzqVar, zzv zzvVar, zzbeb zzbebVar, int i2, zzazn zzaznVar, String str, zzk zzkVar, String str2, String str3) {
        this.zzdsu = null;
        this.zzchd = null;
        this.zzdsv = zzqVar;
        this.zzdjd = zzbebVar;
        this.zzdgz = null;
        this.zzdha = null;
        this.zzdsw = str2;
        this.zzdsx = false;
        this.zzdsy = str3;
        this.zzdsz = null;
        this.orientation = i2;
        this.zzdta = 1;
        this.url = null;
        this.zzbpn = zzaznVar;
        this.zzdtb = str;
        this.zzdtc = zzkVar;
        this.zzbvs = null;
        this.zzdtf = null;
        this.zzdtd = null;
        this.zzdib = null;
        this.zzdic = null;
        this.zzdte = null;
    }

    public AdOverlayInfoParcel(zzvc zzvcVar, zzq zzqVar, zzv zzvVar, zzbeb zzbebVar, boolean z, int i2, zzazn zzaznVar) {
        this.zzdsu = null;
        this.zzchd = zzvcVar;
        this.zzdsv = zzqVar;
        this.zzdjd = zzbebVar;
        this.zzdgz = null;
        this.zzdha = null;
        this.zzdsw = null;
        this.zzdsx = z;
        this.zzdsy = null;
        this.zzdsz = zzvVar;
        this.orientation = i2;
        this.zzdta = 2;
        this.url = null;
        this.zzbpn = zzaznVar;
        this.zzdtb = null;
        this.zzdtc = null;
        this.zzbvs = null;
        this.zzdtf = null;
        this.zzdtd = null;
        this.zzdib = null;
        this.zzdic = null;
        this.zzdte = null;
    }

    public AdOverlayInfoParcel(zzvc zzvcVar, zzq zzqVar, zzahi zzahiVar, zzahk zzahkVar, zzv zzvVar, zzbeb zzbebVar, boolean z, int i2, String str, zzazn zzaznVar) {
        this.zzdsu = null;
        this.zzchd = zzvcVar;
        this.zzdsv = zzqVar;
        this.zzdjd = zzbebVar;
        this.zzdgz = zzahiVar;
        this.zzdha = zzahkVar;
        this.zzdsw = null;
        this.zzdsx = z;
        this.zzdsy = null;
        this.zzdsz = zzvVar;
        this.orientation = i2;
        this.zzdta = 3;
        this.url = str;
        this.zzbpn = zzaznVar;
        this.zzdtb = null;
        this.zzdtc = null;
        this.zzbvs = null;
        this.zzdtf = null;
        this.zzdtd = null;
        this.zzdib = null;
        this.zzdic = null;
        this.zzdte = null;
    }

    public AdOverlayInfoParcel(zzvc zzvcVar, zzq zzqVar, zzahi zzahiVar, zzahk zzahkVar, zzv zzvVar, zzbeb zzbebVar, boolean z, int i2, String str, String str2, zzazn zzaznVar) {
        this.zzdsu = null;
        this.zzchd = zzvcVar;
        this.zzdsv = zzqVar;
        this.zzdjd = zzbebVar;
        this.zzdgz = zzahiVar;
        this.zzdha = zzahkVar;
        this.zzdsw = str2;
        this.zzdsx = z;
        this.zzdsy = str;
        this.zzdsz = zzvVar;
        this.orientation = i2;
        this.zzdta = 3;
        this.url = null;
        this.zzbpn = zzaznVar;
        this.zzdtb = null;
        this.zzdtc = null;
        this.zzbvs = null;
        this.zzdtf = null;
        this.zzdtd = null;
        this.zzdib = null;
        this.zzdic = null;
        this.zzdte = null;
    }

    public AdOverlayInfoParcel(zzd zzdVar, zzvc zzvcVar, zzq zzqVar, zzv zzvVar, zzazn zzaznVar, zzbeb zzbebVar) {
        this.zzdsu = zzdVar;
        this.zzchd = zzvcVar;
        this.zzdsv = zzqVar;
        this.zzdjd = zzbebVar;
        this.zzdgz = null;
        this.zzdha = null;
        this.zzdsw = null;
        this.zzdsx = false;
        this.zzdsy = null;
        this.zzdsz = zzvVar;
        this.orientation = -1;
        this.zzdta = 4;
        this.url = null;
        this.zzbpn = zzaznVar;
        this.zzdtb = null;
        this.zzdtc = null;
        this.zzbvs = null;
        this.zzdtf = null;
        this.zzdtd = null;
        this.zzdib = null;
        this.zzdic = null;
        this.zzdte = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdOverlayInfoParcel(zzd zzdVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, zzazn zzaznVar, String str4, zzk zzkVar, IBinder iBinder6, String str5, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, IBinder iBinder10, String str6) {
        this.zzdsu = zzdVar;
        this.zzchd = (zzvc) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder));
        this.zzdsv = (zzq) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder2));
        this.zzdjd = (zzbeb) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder3));
        this.zzdgz = (zzahi) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder6));
        this.zzdha = (zzahk) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder4));
        this.zzdsw = str;
        this.zzdsx = z;
        this.zzdsy = str2;
        this.zzdsz = (zzv) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder5));
        this.orientation = i2;
        this.zzdta = i3;
        this.url = str3;
        this.zzbpn = zzaznVar;
        this.zzdtb = str4;
        this.zzdtc = zzkVar;
        this.zzbvs = str5;
        this.zzdtf = str6;
        this.zzdtd = (zzcqr) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder7));
        this.zzdib = (zzckn) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder8));
        this.zzdic = (zzdrz) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder9));
        this.zzdte = (zzbg) com.google.android.gms.dynamic.d.y0(b.a.x0(iBinder10));
    }
}
