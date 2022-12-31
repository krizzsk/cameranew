package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzblg extends zzbnt {
    private final View view;
    @Nullable
    private final zzbeb zzdjd;
    private final zzdmz zzftn;
    private final int zzfto;
    private final boolean zzftp;
    private final boolean zzftq;
    @Nullable
    private zzsq zzfuc;
    private final zzbkv zzfud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzblg(zzbnw zzbnwVar, View view, @Nullable zzbeb zzbebVar, zzdmz zzdmzVar, int i2, boolean z, boolean z2, zzbkv zzbkvVar) {
        super(zzbnwVar);
        this.view = view;
        this.zzdjd = zzbebVar;
        this.zzftn = zzdmzVar;
        this.zzfto = i2;
        this.zzftp = z;
        this.zzftq = z2;
        this.zzfud = zzbkvVar;
    }

    public final void zza(zzsh zzshVar) {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            zzbebVar.zza(zzshVar);
        }
    }

    public final boolean zzadp() {
        zzbeb zzbebVar = this.zzdjd;
        return (zzbebVar == null || zzbebVar.zzacx() == null || !this.zzdjd.zzacx().zzadp()) ? false : true;
    }

    public final int zzajh() {
        return this.zzfto;
    }

    public final boolean zzaji() {
        return this.zzftp;
    }

    public final boolean zzajj() {
        return this.zzftq;
    }

    public final zzdmz zzajq() {
        return zzdnu.zza(this.zzesr.zzhjf, this.zzftn);
    }

    public final View zzajr() {
        return this.view;
    }

    public final boolean zzajs() {
        zzbeb zzbebVar = this.zzdjd;
        return zzbebVar != null && zzbebVar.zzacz();
    }

    @Nullable
    public final zzsq zzajt() {
        return this.zzfuc;
    }

    public final void zzb(long j2, int i2) {
        this.zzfud.zzb(j2, i2);
    }

    public final void zza(zzsq zzsqVar) {
        this.zzfuc = zzsqVar;
    }
}
