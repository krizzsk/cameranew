package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzaev;
import com.google.android.gms.internal.ads.zzaey;
import com.google.android.gms.internal.ads.zzane;
import com.google.android.gms.internal.ads.zzarf;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzasd;
import com.google.android.gms.internal.ads.zzaur;
import com.google.android.gms.internal.ads.zzavm;
import com.google.android.gms.internal.ads.zzaxy;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzccy;
import com.google.android.gms.internal.ads.zzcxu;
import com.google.android.gms.internal.ads.zzdid;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzwr;
import com.google.android.gms.internal.ads.zzxi;
import com.google.android.gms.internal.ads.zzxl;
import com.google.android.gms.internal.ads.zzxx;
import com.google.android.gms.internal.ads.zzyg;
import java.util.HashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class ClientApi extends zzxx {
    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zza(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        return zzbgc.zza(context, zzaneVar, i2).zzafi().zzby(context).zzc(zzvsVar).zzfp(str).zzaht().zzahw();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zzb(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        return zzbgc.zza(context, zzaneVar, i2).zzafn().zzbz(context).zzd(zzvsVar).zzfq(str).zzahy().zzaic();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zzc(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, String str, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        zzdid zzahi = zzbgc.zza(context, zzaneVar, i2).zzafl().zzfo(str).zzbx(context).zzahi();
        if (i2 >= ((Integer) zzwr.zzqr().zzd(zzabp.zzcvx)).intValue()) {
            return zzahi.zzahm();
        }
        return zzahi.zzahl();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzyg zzc(com.google.android.gms.dynamic.b bVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzasd zzd(com.google.android.gms.dynamic.b bVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxi zza(com.google.android.gms.dynamic.b bVar, String str, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        return new zzcxu(zzbgc.zza(context, zzaneVar, i2), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaro zzb(com.google.android.gms.dynamic.b bVar) {
        Activity activity = (Activity) com.google.android.gms.dynamic.d.y0(bVar);
        AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(activity.getIntent());
        if (zzd == null) {
            return new zzu(activity);
        }
        int i2 = zzd.zzdta;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return new zzu(activity);
                        }
                        return new zzaa(activity);
                    }
                    return new zzw(activity, zzd);
                }
                return new zzab(activity);
            }
            return new zzac(activity);
        }
        return new com.google.android.gms.ads.internal.overlay.zzr(activity);
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaev zza(com.google.android.gms.dynamic.b bVar, com.google.android.gms.dynamic.b bVar2) {
        return new zzccx((FrameLayout) com.google.android.gms.dynamic.d.y0(bVar), (FrameLayout) com.google.android.gms.dynamic.d.y0(bVar2), 204204000);
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzarf zzc(com.google.android.gms.dynamic.b bVar, zzane zzaneVar, int i2) {
        return zzbgc.zza((Context) com.google.android.gms.dynamic.d.y0(bVar), zzaneVar, i2).zzaft();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaur zza(com.google.android.gms.dynamic.b bVar, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        return zzbgc.zza(context, zzaneVar, i2).zzafq().zzca(context).zzaib().zzaie();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzavm zzb(com.google.android.gms.dynamic.b bVar, String str, zzane zzaneVar, int i2) {
        Context context = (Context) com.google.android.gms.dynamic.d.y0(bVar);
        return zzbgc.zza(context, zzaneVar, i2).zzafq().zzca(context).zzfr(str).zzaib().zzaif();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzyg zza(com.google.android.gms.dynamic.b bVar, int i2) {
        return zzbgc.zzh((Context) com.google.android.gms.dynamic.d.y0(bVar), i2).zzafg();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzxl zza(com.google.android.gms.dynamic.b bVar, zzvs zzvsVar, String str, int i2) {
        return new zzl((Context) com.google.android.gms.dynamic.d.y0(bVar), zzvsVar, str, new zzazn(204204000, i2, true, false));
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaxy zzb(com.google.android.gms.dynamic.b bVar, zzane zzaneVar, int i2) {
        return zzbgc.zza((Context) com.google.android.gms.dynamic.d.y0(bVar), zzaneVar, i2).zzafs();
    }

    @Override // com.google.android.gms.internal.ads.zzxy
    public final zzaey zza(com.google.android.gms.dynamic.b bVar, com.google.android.gms.dynamic.b bVar2, com.google.android.gms.dynamic.b bVar3) {
        return new zzccy((View) com.google.android.gms.dynamic.d.y0(bVar), (HashMap) com.google.android.gms.dynamic.d.y0(bVar2), (HashMap) com.google.android.gms.dynamic.d.y0(bVar3));
    }
}
