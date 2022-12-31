package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.util.ArrayList;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdaz implements zzdfj<Bundle> {
    private final String zzacy;
    private final zzvs zzbpo;
    private final float zzbsd;
    private final boolean zzcii;
    private final int zzdqi;
    private final int zzdqj;
    private final String zzhap;
    private final String zzhaq;
    private final boolean zzhar;

    public zzdaz(zzvs zzvsVar, String str, boolean z, String str2, float f2, int i2, int i3, String str3, boolean z2) {
        q.k(zzvsVar, "the adSize must not be null");
        this.zzbpo = zzvsVar;
        this.zzacy = str;
        this.zzcii = z;
        this.zzhap = str2;
        this.zzbsd = f2;
        this.zzdqi = i2;
        this.zzdqj = i3;
        this.zzhaq = str3;
        this.zzhar = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        String str;
        Bundle bundle2 = bundle;
        zzdnz.zza(bundle2, "smart_w", "full", this.zzbpo.width == -1);
        zzdnz.zza(bundle2, "smart_h", "auto", this.zzbpo.height == -2);
        Boolean bool = Boolean.TRUE;
        zzdnz.zza(bundle2, "ene", bool, this.zzbpo.zzcij);
        zzdnz.zza(bundle2, "rafmt", "102", this.zzbpo.zzcim);
        zzdnz.zza(bundle2, "rafmt", "103", this.zzbpo.zzcin);
        zzdnz.zza(bundle2, "inline_adaptive_slot", bool, this.zzhar);
        zzdnz.zza(bundle2, IjkMediaMeta.IJKM_KEY_FORMAT, this.zzacy);
        zzdnz.zza(bundle2, "fluid", "height", this.zzcii);
        zzdnz.zza(bundle2, "sz", this.zzhap, !TextUtils.isEmpty(str));
        bundle2.putFloat("u_sd", this.zzbsd);
        bundle2.putInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SW, this.zzdqi);
        bundle2.putInt(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SH, this.zzdqj);
        String str2 = this.zzhaq;
        zzdnz.zza(bundle2, "sc", str2, true ^ TextUtils.isEmpty(str2));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        zzvs[] zzvsVarArr = this.zzbpo.zzcih;
        if (zzvsVarArr == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("height", this.zzbpo.height);
            bundle3.putInt("width", this.zzbpo.width);
            bundle3.putBoolean("is_fluid_height", this.zzbpo.zzcii);
            arrayList.add(bundle3);
        } else {
            for (zzvs zzvsVar : zzvsVarArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzvsVar.zzcii);
                bundle4.putInt("height", zzvsVar.height);
                bundle4.putInt("width", zzvsVar.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}
