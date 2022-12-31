package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnp {
    public final zzvs zzbpo;
    public final zzaeh zzdoe;
    @Nullable
    public final zzajt zzdvt;
    public final int zzgzc;
    public final boolean zzhar;
    @Nullable
    public final zzxz zzhku;
    @Nullable
    public final zzaau zzhkv;
    public final zzvl zzhkw;
    public final String zzhkx;
    public final ArrayList<String> zzhky;
    public final ArrayList<String> zzhkz;
    public final zzvx zzhla;
    public final AdManagerAdViewOptions zzhlb;
    public final PublisherAdViewOptions zzhlc;
    public final zzxt zzhld;
    public final zzdnc zzhle;

    private zzdnp(zzdnr zzdnrVar) {
        zzaau zzaauVar;
        zzaeh zzq;
        this.zzbpo = zzdnr.zza(zzdnrVar);
        this.zzhkx = zzdnr.zzb(zzdnrVar);
        this.zzhku = zzdnr.zzc(zzdnrVar);
        this.zzhkw = new zzvl(zzdnr.zzn(zzdnrVar).versionCode, zzdnr.zzn(zzdnrVar).zzchn, zzdnr.zzn(zzdnrVar).extras, zzdnr.zzn(zzdnrVar).zzcho, zzdnr.zzn(zzdnrVar).zzchp, zzdnr.zzn(zzdnrVar).zzchq, zzdnr.zzn(zzdnrVar).zzado, zzdnr.zzn(zzdnrVar).zzbni || zzdnr.zzo(zzdnrVar), zzdnr.zzn(zzdnrVar).zzchr, zzdnr.zzn(zzdnrVar).zzchs, zzdnr.zzn(zzdnrVar).zznb, zzdnr.zzn(zzdnrVar).zzcht, zzdnr.zzn(zzdnrVar).zzchu, zzdnr.zzn(zzdnrVar).zzchv, zzdnr.zzn(zzdnrVar).zzchw, zzdnr.zzn(zzdnrVar).zzchx, zzdnr.zzn(zzdnrVar).zzchy, zzdnr.zzn(zzdnrVar).zzchz, zzdnr.zzn(zzdnrVar).zzcia, zzdnr.zzn(zzdnrVar).zzadp, zzdnr.zzn(zzdnrVar).zzadq, zzdnr.zzn(zzdnrVar).zzcib, com.google.android.gms.ads.internal.util.zzj.zzdf(zzdnr.zzn(zzdnrVar).zzcic));
        if (zzdnr.zzp(zzdnrVar) != null) {
            zzaauVar = zzdnr.zzp(zzdnrVar);
        } else {
            zzaauVar = zzdnr.zzq(zzdnrVar) != null ? zzdnr.zzq(zzdnrVar).zzdfu : null;
        }
        this.zzhkv = zzaauVar;
        this.zzhky = zzdnr.zzd(zzdnrVar);
        this.zzhkz = zzdnr.zze(zzdnrVar);
        if (zzdnr.zzd(zzdnrVar) == null) {
            zzq = null;
        } else if (zzdnr.zzq(zzdnrVar) == null) {
            zzq = new zzaeh(new NativeAdOptions.Builder().build());
        } else {
            zzq = zzdnr.zzq(zzdnrVar);
        }
        this.zzdoe = zzq;
        this.zzhla = zzdnr.zzf(zzdnrVar);
        this.zzgzc = zzdnr.zzg(zzdnrVar);
        this.zzhlb = zzdnr.zzh(zzdnrVar);
        this.zzhlc = zzdnr.zzi(zzdnrVar);
        this.zzhld = zzdnr.zzj(zzdnrVar);
        this.zzdvt = zzdnr.zzk(zzdnrVar);
        this.zzhle = new zzdnc(zzdnr.zzl(zzdnrVar));
        this.zzhar = zzdnr.zzm(zzdnrVar);
    }

    public final zzagl zzavc() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhlc;
        if (publisherAdViewOptions == null && this.zzhlb == null) {
            return null;
        }
        if (publisherAdViewOptions != null) {
            return publisherAdViewOptions.zzjr();
        }
        return this.zzhlb.zzjr();
    }
}
