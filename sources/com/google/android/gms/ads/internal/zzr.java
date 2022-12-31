package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.util.zzam;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzakn;
import com.google.android.gms.internal.ads.zzama;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzarl;
import com.google.android.gms.internal.ads.zzaub;
import com.google.android.gms.internal.ads.zzaxc;
import com.google.android.gms.internal.ads.zzayo;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzrl;
import com.google.android.gms.internal.ads.zzsz;
import com.google.android.gms.internal.ads.zzts;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzr {
    private static zzr B = new zzr();
    private final zzbai A;
    private final com.google.android.gms.ads.internal.overlay.zzb a;
    private final com.google.android.gms.ads.internal.overlay.zzm b;
    private final com.google.android.gms.ads.internal.util.zzj c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbej f3516d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.ads.internal.util.zzr f3517e;

    /* renamed from: f  reason: collision with root package name */
    private final zzrl f3518f;

    /* renamed from: g  reason: collision with root package name */
    private final zzayo f3519g;

    /* renamed from: h  reason: collision with root package name */
    private final zzae f3520h;

    /* renamed from: i  reason: collision with root package name */
    private final zzsz f3521i;

    /* renamed from: j  reason: collision with root package name */
    private final Clock f3522j;

    /* renamed from: k  reason: collision with root package name */
    private final zze f3523k;

    /* renamed from: l  reason: collision with root package name */
    private final zzabu f3524l;
    private final zzam m;
    private final zzaub n;
    private final zzazz o;
    private final zzama p;
    private final zzbl q;
    private final zzy r;
    private final zzx s;
    private final zzanc t;
    private final zzbo u;
    private final zzarl v;
    private final zzts w;
    private final zzaxc x;
    private final zzbv y;
    private final zzbde z;

    protected zzr() {
        this(new com.google.android.gms.ads.internal.overlay.zzb(), new com.google.android.gms.ads.internal.overlay.zzm(), new com.google.android.gms.ads.internal.util.zzj(), new zzbej(), com.google.android.gms.ads.internal.util.zzr.zzdg(Build.VERSION.SDK_INT), new zzrl(), new zzayo(), new zzae(), new zzsz(), com.google.android.gms.common.util.h.getInstance(), new zze(), new zzabu(), new zzam(), new zzaub(), new zzakn(), new zzazz(), new zzama(), new zzbl(), new zzy(), new zzx(), new zzanc(), new zzbo(), new zzarl(), new zzts(), new zzaxc(), new zzbv(), new zzbde(), new zzbai());
    }

    public static com.google.android.gms.ads.internal.overlay.zzb zzkp() {
        return B.a;
    }

    public static com.google.android.gms.ads.internal.overlay.zzm zzkq() {
        return B.b;
    }

    public static com.google.android.gms.ads.internal.util.zzj zzkr() {
        return B.c;
    }

    public static zzbej zzks() {
        return B.f3516d;
    }

    public static com.google.android.gms.ads.internal.util.zzr zzkt() {
        return B.f3517e;
    }

    public static zzrl zzku() {
        return B.f3518f;
    }

    public static zzayo zzkv() {
        return B.f3519g;
    }

    public static zzae zzkw() {
        return B.f3520h;
    }

    public static zzsz zzkx() {
        return B.f3521i;
    }

    public static Clock zzky() {
        return B.f3522j;
    }

    public static zze zzkz() {
        return B.f3523k;
    }

    public static zzabu zzla() {
        return B.f3524l;
    }

    public static zzam zzlb() {
        return B.m;
    }

    public static zzaub zzlc() {
        return B.n;
    }

    public static zzazz zzld() {
        return B.o;
    }

    public static zzama zzle() {
        return B.p;
    }

    public static zzbl zzlf() {
        return B.q;
    }

    public static zzarl zzlg() {
        return B.v;
    }

    public static zzy zzlh() {
        return B.r;
    }

    public static zzx zzli() {
        return B.s;
    }

    public static zzanc zzlj() {
        return B.t;
    }

    public static zzbo zzlk() {
        return B.u;
    }

    public static zzts zzll() {
        return B.w;
    }

    public static zzbv zzlm() {
        return B.y;
    }

    public static zzbde zzln() {
        return B.z;
    }

    public static zzbai zzlo() {
        return B.A;
    }

    public static zzaxc zzlp() {
        return B.x;
    }

    private zzr(com.google.android.gms.ads.internal.overlay.zzb zzbVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar, com.google.android.gms.ads.internal.util.zzj zzjVar, zzbej zzbejVar, com.google.android.gms.ads.internal.util.zzr zzrVar, zzrl zzrlVar, zzayo zzayoVar, zzae zzaeVar, zzsz zzszVar, Clock clock, zze zzeVar, zzabu zzabuVar, zzam zzamVar, zzaub zzaubVar, zzakn zzaknVar, zzazz zzazzVar, zzama zzamaVar, zzbl zzblVar, zzy zzyVar, zzx zzxVar, zzanc zzancVar, zzbo zzboVar, zzarl zzarlVar, zzts zztsVar, zzaxc zzaxcVar, zzbv zzbvVar, zzbde zzbdeVar, zzbai zzbaiVar) {
        this.a = zzbVar;
        this.b = zzmVar;
        this.c = zzjVar;
        this.f3516d = zzbejVar;
        this.f3517e = zzrVar;
        this.f3518f = zzrlVar;
        this.f3519g = zzayoVar;
        this.f3520h = zzaeVar;
        this.f3521i = zzszVar;
        this.f3522j = clock;
        this.f3523k = zzeVar;
        this.f3524l = zzabuVar;
        this.m = zzamVar;
        this.n = zzaubVar;
        this.o = zzazzVar;
        this.p = zzamaVar;
        this.q = zzblVar;
        this.r = zzyVar;
        this.s = zzxVar;
        this.t = zzancVar;
        this.u = zzboVar;
        this.v = zzarlVar;
        this.w = zztsVar;
        this.x = zzaxcVar;
        this.y = zzbvVar;
        this.z = zzbdeVar;
        this.A = zzbaiVar;
    }
}
