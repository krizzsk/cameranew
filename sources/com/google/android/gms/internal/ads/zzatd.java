package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzatd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatd> CREATOR = new zzatc();
    private final int errorCode;
    private final int orientation;
    private final int versionCode;
    @Nullable
    private final zzatf zzboj;
    private final boolean zzbpl;
    private final boolean zzbpm;
    private final boolean zzbrr;
    private final String zzbvs;
    private final boolean zzcii;
    private final boolean zzcij;
    private final List<String> zzdmp;
    private final List<String> zzdmq;
    private final List<String> zzdmr;
    private final List<String> zzdmt;
    private final boolean zzdmu;
    private final long zzdmw;
    private final String zzdsw;
    private final boolean zzduk;
    @Nullable
    private String zzdux;
    private final boolean zzdvj;
    private String zzdvw;
    private final long zzdvx;
    private final boolean zzdvy;
    private final long zzdvz;
    private final List<String> zzdwa;
    private final String zzdwb;
    private final long zzdwc;
    private final String zzdwd;
    private final boolean zzdwe;
    private final String zzdwf;
    private final String zzdwg;
    private final boolean zzdwh;
    private final boolean zzdwi;
    private final boolean zzdwj;
    private zzatp zzdwk;
    private String zzdwl;
    @Nullable
    private final zzavj zzdwm;
    @Nullable
    private final List<String> zzdwn;
    @Nullable
    private final List<String> zzdwo;
    private final boolean zzdwp;
    @Nullable
    private final String zzdwq;
    @Nullable
    private final zzawu zzdwr;
    @Nullable
    private final String zzdws;
    private final boolean zzdwt;
    private Bundle zzdwu;
    private final int zzdwv;
    private final boolean zzdww;
    @Nullable
    private final String zzdwx;
    @Nullable
    private String zzdwy;
    private boolean zzdwz;
    private boolean zzdxa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatd(int i2, String str, String str2, List<String> list, int i3, List<String> list2, long j2, boolean z, long j3, List<String> list3, long j4, int i4, String str3, long j5, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, zzatp zzatpVar, String str7, String str8, boolean z8, boolean z9, zzavj zzavjVar, List<String> list4, List<String> list5, boolean z10, zzatf zzatfVar, String str9, List<String> list6, boolean z11, String str10, zzawu zzawuVar, String str11, boolean z12, boolean z13, Bundle bundle, boolean z14, int i5, boolean z15, List<String> list7, boolean z16, String str12, @Nullable String str13, boolean z17, boolean z18) {
        zzats zzatsVar;
        this.versionCode = i2;
        this.zzdsw = str;
        this.zzdvw = str2;
        this.zzdmp = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i3;
        this.zzdmq = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdvx = j2;
        this.zzdvy = z;
        this.zzdvz = j3;
        this.zzdwa = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdmw = j4;
        this.orientation = i4;
        this.zzdwb = str3;
        this.zzdwc = j5;
        this.zzdwd = str4;
        this.zzdwe = z2;
        this.zzdwf = str5;
        this.zzdwg = str6;
        this.zzdwh = z3;
        this.zzbrr = z4;
        this.zzduk = z5;
        this.zzdwi = z6;
        this.zzdwt = z12;
        this.zzdwj = z7;
        this.zzdwk = zzatpVar;
        this.zzdwl = str7;
        this.zzbvs = str8;
        if (this.zzdvw == null && zzatpVar != null && (zzatsVar = (zzats) zzatpVar.zza(zzats.CREATOR)) != null && !TextUtils.isEmpty(zzatsVar.zzdxm)) {
            this.zzdvw = zzatsVar.zzdxm;
        }
        this.zzcii = z8;
        this.zzcij = z9;
        this.zzdwm = zzavjVar;
        this.zzdwn = list4;
        this.zzdwo = list5;
        this.zzdwp = z10;
        this.zzboj = zzatfVar;
        this.zzdux = str9;
        this.zzdmt = list6;
        this.zzdmu = z11;
        this.zzdwq = str10;
        this.zzdwr = zzawuVar;
        this.zzdws = str11;
        this.zzdvj = z13;
        this.zzdwu = bundle;
        this.zzbpl = z14;
        this.zzdwv = i5;
        this.zzdww = z15;
        this.zzdmr = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.zzbpm = z16;
        this.zzdwx = str12;
        this.zzdwy = str13;
        this.zzdwz = z17;
        this.zzdxa = z18;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.versionCode);
        a.v(parcel, 2, this.zzdsw, false);
        a.v(parcel, 3, this.zzdvw, false);
        a.x(parcel, 4, this.zzdmp, false);
        a.m(parcel, 5, this.errorCode);
        a.x(parcel, 6, this.zzdmq, false);
        a.q(parcel, 7, this.zzdvx);
        a.c(parcel, 8, this.zzdvy);
        a.q(parcel, 9, this.zzdvz);
        a.x(parcel, 10, this.zzdwa, false);
        a.q(parcel, 11, this.zzdmw);
        a.m(parcel, 12, this.orientation);
        a.v(parcel, 13, this.zzdwb, false);
        a.q(parcel, 14, this.zzdwc);
        a.v(parcel, 15, this.zzdwd, false);
        a.c(parcel, 18, this.zzdwe);
        a.v(parcel, 19, this.zzdwf, false);
        a.v(parcel, 21, this.zzdwg, false);
        a.c(parcel, 22, this.zzdwh);
        a.c(parcel, 23, this.zzbrr);
        a.c(parcel, 24, this.zzduk);
        a.c(parcel, 25, this.zzdwi);
        a.c(parcel, 26, this.zzdwj);
        a.t(parcel, 28, this.zzdwk, i2, false);
        a.v(parcel, 29, this.zzdwl, false);
        a.v(parcel, 30, this.zzbvs, false);
        a.c(parcel, 31, this.zzcii);
        a.c(parcel, 32, this.zzcij);
        a.t(parcel, 33, this.zzdwm, i2, false);
        a.x(parcel, 34, this.zzdwn, false);
        a.x(parcel, 35, this.zzdwo, false);
        a.c(parcel, 36, this.zzdwp);
        a.t(parcel, 37, this.zzboj, i2, false);
        a.v(parcel, 39, this.zzdux, false);
        a.x(parcel, 40, this.zzdmt, false);
        a.c(parcel, 42, this.zzdmu);
        a.v(parcel, 43, this.zzdwq, false);
        a.t(parcel, 44, this.zzdwr, i2, false);
        a.v(parcel, 45, this.zzdws, false);
        a.c(parcel, 46, this.zzdwt);
        a.c(parcel, 47, this.zzdvj);
        a.e(parcel, 48, this.zzdwu, false);
        a.c(parcel, 49, this.zzbpl);
        a.m(parcel, 50, this.zzdwv);
        a.c(parcel, 51, this.zzdww);
        a.x(parcel, 52, this.zzdmr, false);
        a.c(parcel, 53, this.zzbpm);
        a.v(parcel, 54, this.zzdwx, false);
        a.v(parcel, 55, this.zzdwy, false);
        a.c(parcel, 56, this.zzdwz);
        a.c(parcel, 57, this.zzdxa);
        a.b(parcel, a);
    }
}
