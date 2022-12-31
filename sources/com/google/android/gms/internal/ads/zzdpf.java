package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzdpf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdpf> CREATOR = new zzdpj();
    @Nullable
    public final Context context;
    private final zzdpi[] zzhni;
    private final int[] zzhnj;
    private final int[] zzhnk;
    private final int zzhnl;
    public final zzdpi zzhnm;
    public final int zzhnn;
    public final int zzhno;
    public final int zzhnp;
    public final String zzhnq;
    private final int zzhnr;
    public final int zzhns;
    private final int zzhnt;
    private final int zzhnu;

    private zzdpf(@Nullable Context context, zzdpi zzdpiVar, int i2, int i3, int i4, String str, String str2, String str3) {
        int i5;
        this.zzhni = zzdpi.values();
        this.zzhnj = zzdph.zzawg();
        this.zzhnk = zzdpk.zzawh();
        this.context = context;
        this.zzhnl = zzdpiVar.ordinal();
        this.zzhnm = zzdpiVar;
        this.zzhnn = i2;
        this.zzhno = i3;
        this.zzhnp = i4;
        this.zzhnq = str;
        if ("oldest".equals(str2)) {
            i5 = zzdph.zzhnx;
        } else if (!"lru".equals(str2) && "lfu".equals(str2)) {
            i5 = zzdph.zzhnz;
        } else {
            i5 = zzdph.zzhny;
        }
        this.zzhns = i5;
        this.zzhnr = i5 - 1;
        "onAdClosed".equals(str3);
        int i6 = zzdpk.zzhof;
        this.zzhnu = i6;
        this.zzhnt = i6 - 1;
    }

    public static zzdpf zza(zzdpi zzdpiVar, Context context) {
        if (zzdpiVar == zzdpi.Rewarded) {
            return new zzdpf(context, zzdpiVar, ((Integer) zzwr.zzqr().zzd(zzabp.zzcye)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcyk)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcym)).intValue(), (String) zzwr.zzqr().zzd(zzabp.zzcyo), (String) zzwr.zzqr().zzd(zzabp.zzcyg), (String) zzwr.zzqr().zzd(zzabp.zzcyi));
        } else if (zzdpiVar == zzdpi.Interstitial) {
            return new zzdpf(context, zzdpiVar, ((Integer) zzwr.zzqr().zzd(zzabp.zzcyf)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcyl)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcyn)).intValue(), (String) zzwr.zzqr().zzd(zzabp.zzcyp), (String) zzwr.zzqr().zzd(zzabp.zzcyh), (String) zzwr.zzqr().zzd(zzabp.zzcyj));
        } else if (zzdpiVar == zzdpi.AppOpen) {
            return new zzdpf(context, zzdpiVar, ((Integer) zzwr.zzqr().zzd(zzabp.zzcys)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcyu)).intValue(), ((Integer) zzwr.zzqr().zzd(zzabp.zzcyv)).intValue(), (String) zzwr.zzqr().zzd(zzabp.zzcyq), (String) zzwr.zzqr().zzd(zzabp.zzcyr), (String) zzwr.zzqr().zzd(zzabp.zzcyt));
        } else {
            return null;
        }
    }

    public static boolean zzawe() {
        return ((Boolean) zzwr.zzqr().zzd(zzabp.zzcyd)).booleanValue();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.m(parcel, 1, this.zzhnl);
        a.m(parcel, 2, this.zzhnn);
        a.m(parcel, 3, this.zzhno);
        a.m(parcel, 4, this.zzhnp);
        a.v(parcel, 5, this.zzhnq, false);
        a.m(parcel, 6, this.zzhnr);
        a.m(parcel, 7, this.zzhnt);
        a.b(parcel, a);
    }

    public zzdpf(int i2, int i3, int i4, int i5, String str, int i6, int i7) {
        zzdpi[] values = zzdpi.values();
        this.zzhni = values;
        int[] zzawg = zzdph.zzawg();
        this.zzhnj = zzawg;
        int[] zzawh = zzdpk.zzawh();
        this.zzhnk = zzawh;
        this.context = null;
        this.zzhnl = i2;
        this.zzhnm = values[i2];
        this.zzhnn = i3;
        this.zzhno = i4;
        this.zzhnp = i5;
        this.zzhnq = str;
        this.zzhnr = i6;
        this.zzhns = zzawg[i6];
        this.zzhnt = i7;
        this.zzhnu = zzawh[i7];
    }
}
