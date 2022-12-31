package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.pinguo.camera360.effect.model.entity.Effect;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzday implements zzdfi<zzdaz> {
    private final Context context;
    private final zzayo zzbqd;
    private final zzdnp zzfwy;
    private final zzdfi<zzdfp> zzhao;

    public zzday(zzdch<zzdfp> zzdchVar, zzdnp zzdnpVar, Context context, zzayo zzayoVar) {
        this.zzhao = zzdchVar;
        this.zzfwy = zzdnpVar;
        this.context = context;
        this.zzbqd = zzayoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdaz zza(zzdfp zzdfpVar) {
        String str;
        boolean z;
        String str2;
        float f2;
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics;
        zzvs zzvsVar = this.zzfwy.zzbpo;
        zzvs[] zzvsVarArr = zzvsVar.zzcih;
        if (zzvsVarArr == null) {
            str = zzvsVar.zzacy;
            z = zzvsVar.zzcii;
        } else {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvs zzvsVar2 : zzvsVarArr) {
                boolean z4 = zzvsVar2.zzcii;
                if (!z4 && !z2) {
                    str = zzvsVar2.zzacy;
                    z2 = true;
                }
                if (z4 && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        }
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f2 = 0.0f;
            i2 = 0;
            i3 = 0;
        } else {
            float f3 = displayMetrics.density;
            int i5 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            str2 = this.zzbqd.zzxs().zzyt();
            i2 = i5;
            f2 = f3;
        }
        StringBuilder sb = new StringBuilder();
        zzvs[] zzvsVarArr2 = zzvsVar.zzcih;
        if (zzvsVarArr2 != null) {
            boolean z5 = false;
            for (zzvs zzvsVar3 : zzvsVarArr2) {
                if (zzvsVar3.zzcii) {
                    z5 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append(Effect.DIVIDER);
                    }
                    int i6 = zzvsVar3.width;
                    if (i6 == -1 && f2 != 0.0f) {
                        i6 = (int) (zzvsVar3.widthPixels / f2);
                    }
                    sb.append(i6);
                    sb.append("x");
                    int i7 = zzvsVar3.height;
                    if (i7 == -2 && f2 != 0.0f) {
                        i7 = (int) (zzvsVar3.heightPixels / f2);
                    }
                    sb.append(i7);
                }
            }
            if (z5) {
                if (sb.length() != 0) {
                    i4 = 0;
                    sb.insert(0, Effect.DIVIDER);
                } else {
                    i4 = 0;
                }
                sb.insert(i4, "320x50");
            }
        }
        return new zzdaz(zzvsVar, str, z, sb.toString(), f2, i2, i3, str2, this.zzfwy.zzhar);
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdaz> zzasy() {
        return zzdzk.zzb(this.zzhao.zzasy(), new zzdvz(this) { // from class: com.google.android.gms.internal.ads.zzdbb
            private final zzday zzhat;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhat = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return this.zzhat.zza((zzdfp) obj);
            }
        }, zzazp.zzeih);
    }
}
