package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.util.Arrays;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcge extends zzafm {
    private final Context zzaad;
    private final zzccd zzgch;
    private zzcbu zzgfm;
    private zzccz zzgit;

    public zzcge(Context context, zzccd zzccdVar, zzccz zzcczVar, zzcbu zzcbuVar) {
        this.zzaad = context;
        this.zzgch = zzccdVar;
        this.zzgit = zzcczVar;
        this.zzgfm = zzcbuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void destroy() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.destroy();
        }
        this.zzgfm = null;
        this.zzgit = null;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzaed> zzaoc = this.zzgch.zzaoc();
        SimpleArrayMap<String, String> zzaoe = this.zzgch.zzaoe();
        String[] strArr = new String[zzaoc.size() + zzaoe.size()];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < zzaoc.size()) {
            strArr[i4] = zzaoc.keyAt(i3);
            i3++;
            i4++;
        }
        while (i2 < zzaoe.size()) {
            strArr[i4] = zzaoe.keyAt(i2);
            i2++;
            i4++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final String getCustomTemplateId() {
        return this.zzgch.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final zzzc getVideoController() {
        return this.zzgch.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void performClick(String str) {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzfw(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void recordImpression() {
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzanj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final String zzct(String str) {
        return this.zzgch.zzaoe().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final zzaer zzcu(String str) {
        return this.zzgch.zzaoc().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zzp(b bVar) {
        Object y0 = d.y0(bVar);
        if (y0 instanceof ViewGroup) {
            zzccz zzcczVar = this.zzgit;
            if (zzcczVar != null && zzcczVar.zza((ViewGroup) y0)) {
                this.zzgch.zzanz().zza(new zzcgd(this));
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zzq(b bVar) {
        zzcbu zzcbuVar;
        Object y0 = d.y0(bVar);
        if (!(y0 instanceof View) || this.zzgch.zzaob() == null || (zzcbuVar = this.zzgfm) == null) {
            return;
        }
        zzcbuVar.zzaa((View) y0);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final b zztm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final b zztr() {
        return d.z0(this.zzaad);
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zzts() {
        zzcbu zzcbuVar = this.zzgfm;
        return (zzcbuVar == null || zzcbuVar.zzanq()) && this.zzgch.zzaoa() != null && this.zzgch.zzanz() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final boolean zztt() {
        b zzaob = this.zzgch.zzaob();
        if (zzaob != null) {
            com.google.android.gms.ads.internal.zzr.zzlg().zzab(zzaob);
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcvs)).booleanValue() || this.zzgch.zzaoa() == null) {
                return true;
            }
            this.zzgch.zzaoa().zza("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzazk.zzex("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zztu() {
        String zzaod = this.zzgch.zzaod();
        if ("Google".equals(zzaod)) {
            zzazk.zzex("Illegal argument specified for omid partner name.");
            return;
        }
        zzcbu zzcbuVar = this.zzgfm;
        if (zzcbuVar != null) {
            zzcbuVar.zzi(zzaod, false);
        }
    }
}
