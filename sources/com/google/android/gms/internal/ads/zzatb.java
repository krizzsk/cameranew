package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzatb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatb> CREATOR = new zzata();
    private final ApplicationInfo applicationInfo;
    private final int versionCode;
    private final zzazn zzbpn;
    private final zzvs zzbpo;
    private final float zzbsd;
    private final String zzbut;
    private final String zzcjn;
    private final boolean zzdmu;
    private final zzaeh zzdoe;
    private final List<String> zzdof;
    private final int zzdqi;
    private final int zzdqj;
    @Nullable
    private final Bundle zzduc;
    private final zzvl zzdud;
    @Nullable
    private final PackageInfo zzdue;
    private final String zzduf;
    private final String zzdug;
    private final Bundle zzduh;
    private final int zzdui;
    private final Bundle zzduj;
    private final boolean zzduk;
    private final String zzdul;
    private final long zzdum;
    private final String zzdun;
    @Nullable
    private final List<String> zzduo;
    private final String zzdup;
    private final List<String> zzduq;
    private final long zzdur;
    private final String zzdus;
    private final float zzdut;
    private final int zzduu;
    private final int zzduv;
    private final boolean zzduw;
    private final String zzdux;
    private final boolean zzduy;
    private final String zzduz;
    private final int zzdva;
    private final Bundle zzdvb;
    private final String zzdvc;
    @Nullable
    private final zzzi zzdvd;
    private final boolean zzdve;
    private final Bundle zzdvf;
    @Nullable
    private final String zzdvg;
    @Nullable
    private final String zzdvh;
    @Nullable
    private final String zzdvi;
    private final boolean zzdvj;
    private final List<Integer> zzdvk;
    private final String zzdvl;
    private final List<String> zzdvm;
    private final int zzdvn;
    private final boolean zzdvo;
    private final boolean zzdvp;
    private final boolean zzdvq;
    private final ArrayList<String> zzdvr;
    private final String zzdvs;
    private final zzajt zzdvt;
    @Nullable
    private final String zzdvu;
    private final Bundle zzdvv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatb(int i2, Bundle bundle, zzvl zzvlVar, zzvs zzvsVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzazn zzaznVar, Bundle bundle2, int i3, List<String> list, Bundle bundle3, boolean z, int i4, int i5, float f2, String str5, long j2, String str6, List<String> list2, String str7, zzaeh zzaehVar, List<String> list3, long j3, String str8, float f3, boolean z2, int i6, int i7, boolean z3, String str9, String str10, boolean z4, int i8, Bundle bundle4, String str11, zzzi zzziVar, boolean z5, Bundle bundle5, @Nullable String str12, @Nullable String str13, @Nullable String str14, boolean z6, List<Integer> list4, String str15, List<String> list5, int i9, boolean z7, boolean z8, boolean z9, ArrayList<String> arrayList, String str16, zzajt zzajtVar, @Nullable String str17, Bundle bundle6) {
        List<String> unmodifiableList;
        List<String> unmodifiableList2;
        this.versionCode = i2;
        this.zzduc = bundle;
        this.zzdud = zzvlVar;
        this.zzbpo = zzvsVar;
        this.zzbut = str;
        this.applicationInfo = applicationInfo;
        this.zzdue = packageInfo;
        this.zzduf = str2;
        this.zzdug = str3;
        this.zzcjn = str4;
        this.zzbpn = zzaznVar;
        this.zzduh = bundle2;
        this.zzdui = i3;
        this.zzdof = list;
        if (list3 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list3);
        }
        this.zzduq = unmodifiableList;
        this.zzduj = bundle3;
        this.zzduk = z;
        this.zzdqi = i4;
        this.zzdqj = i5;
        this.zzbsd = f2;
        this.zzdul = str5;
        this.zzdum = j2;
        this.zzdun = str6;
        if (list2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.zzduo = unmodifiableList2;
        this.zzdup = str7;
        this.zzdoe = zzaehVar;
        this.zzdur = j3;
        this.zzdus = str8;
        this.zzdut = f3;
        this.zzduy = z2;
        this.zzduu = i6;
        this.zzduv = i7;
        this.zzduw = z3;
        this.zzdux = str9;
        this.zzduz = str10;
        this.zzdmu = z4;
        this.zzdva = i8;
        this.zzdvb = bundle4;
        this.zzdvc = str11;
        this.zzdvd = zzziVar;
        this.zzdve = z5;
        this.zzdvf = bundle5;
        this.zzdvg = str12;
        this.zzdvh = str13;
        this.zzdvi = str14;
        this.zzdvj = z6;
        this.zzdvk = list4;
        this.zzdvl = str15;
        this.zzdvm = list5;
        this.zzdvn = i9;
        this.zzdvo = z7;
        this.zzdvp = z8;
        this.zzdvq = z9;
        this.zzdvr = arrayList;
        this.zzdvs = str16;
        this.zzdvt = zzajtVar;
        this.zzdvu = str17;
        this.zzdvv = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.e(parcel, 2, this.zzduc, false);
        a.t(parcel, 3, this.zzdud, i2, false);
        a.t(parcel, 4, this.zzbpo, i2, false);
        a.v(parcel, 5, this.zzbut, false);
        a.t(parcel, 6, this.applicationInfo, i2, false);
        a.t(parcel, 7, this.zzdue, i2, false);
        a.v(parcel, 8, this.zzduf, false);
        a.v(parcel, 9, this.zzdug, false);
        a.v(parcel, 10, this.zzcjn, false);
        a.t(parcel, 11, this.zzbpn, i2, false);
        a.e(parcel, 12, this.zzduh, false);
        a.m(parcel, 13, this.zzdui);
        a.x(parcel, 14, this.zzdof, false);
        a.e(parcel, 15, this.zzduj, false);
        a.c(parcel, 16, this.zzduk);
        a.m(parcel, 18, this.zzdqi);
        a.m(parcel, 19, this.zzdqj);
        a.j(parcel, 20, this.zzbsd);
        a.v(parcel, 21, this.zzdul, false);
        a.q(parcel, 25, this.zzdum);
        a.v(parcel, 26, this.zzdun, false);
        a.x(parcel, 27, this.zzduo, false);
        a.v(parcel, 28, this.zzdup, false);
        a.t(parcel, 29, this.zzdoe, i2, false);
        a.x(parcel, 30, this.zzduq, false);
        a.q(parcel, 31, this.zzdur);
        a.v(parcel, 33, this.zzdus, false);
        a.j(parcel, 34, this.zzdut);
        a.m(parcel, 35, this.zzduu);
        a.m(parcel, 36, this.zzduv);
        a.c(parcel, 37, this.zzduw);
        a.v(parcel, 39, this.zzdux, false);
        a.c(parcel, 40, this.zzduy);
        a.v(parcel, 41, this.zzduz, false);
        a.c(parcel, 42, this.zzdmu);
        a.m(parcel, 43, this.zzdva);
        a.e(parcel, 44, this.zzdvb, false);
        a.v(parcel, 45, this.zzdvc, false);
        a.t(parcel, 46, this.zzdvd, i2, false);
        a.c(parcel, 47, this.zzdve);
        a.e(parcel, 48, this.zzdvf, false);
        a.v(parcel, 49, this.zzdvg, false);
        a.v(parcel, 50, this.zzdvh, false);
        a.v(parcel, 51, this.zzdvi, false);
        a.c(parcel, 52, this.zzdvj);
        a.n(parcel, 53, this.zzdvk, false);
        a.v(parcel, 54, this.zzdvl, false);
        a.x(parcel, 55, this.zzdvm, false);
        a.m(parcel, 56, this.zzdvn);
        a.c(parcel, 57, this.zzdvo);
        a.c(parcel, 58, this.zzdvp);
        a.c(parcel, 59, this.zzdvq);
        a.x(parcel, 60, this.zzdvr, false);
        a.v(parcel, 61, this.zzdvs, false);
        a.t(parcel, 63, this.zzdvt, i2, false);
        a.v(parcel, 64, this.zzdvu, false);
        a.e(parcel, 65, this.zzdvv, false);
        a.b(parcel, a);
    }
}
