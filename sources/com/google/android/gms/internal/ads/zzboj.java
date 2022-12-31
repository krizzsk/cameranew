package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzboj {
    private final String zzcio;
    private final zzdnl zzeyz;
    private final zzdmw zzfrj;

    public zzboj(zzdnl zzdnlVar, zzdmw zzdmwVar, @Nullable String str) {
        this.zzeyz = zzdnlVar;
        this.zzfrj = zzdmwVar;
        this.zzcio = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzdnl zzakw() {
        return this.zzeyz;
    }

    public final zzdmw zzakx() {
        return this.zzfrj;
    }

    public final zzdnb zzaky() {
        return this.zzeyz.zzhks.zzess;
    }

    public final String zzakz() {
        return this.zzcio;
    }
}
