package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.internal.ads.zzug;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcai implements com.google.android.gms.ads.internal.overlay.zzq, zzbtb {
    private final Context context;
    private final zzazn zzbpn;
    @Nullable
    private final zzbeb zzdjd;
    private final zzdmw zzesr;
    @Nullable
    private b zzfvs;
    private final zzug.zza.EnumC0160zza zzgbp;

    public zzcai(Context context, @Nullable zzbeb zzbebVar, zzdmw zzdmwVar, zzazn zzaznVar, zzug.zza.EnumC0160zza enumC0160zza) {
        this.context = context;
        this.zzdjd = zzbebVar;
        this.zzesr = zzdmwVar;
        this.zzbpn = zzaznVar;
        this.zzgbp = enumC0160zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void onAdLoaded() {
        zzarm zzarmVar;
        zzarm zzarmVar2;
        zzarn zzarnVar;
        zzug.zza.EnumC0160zza enumC0160zza = this.zzgbp;
        if ((enumC0160zza == zzug.zza.EnumC0160zza.REWARD_BASED_VIDEO_AD || enumC0160zza == zzug.zza.EnumC0160zza.INTERSTITIAL || enumC0160zza == zzug.zza.EnumC0160zza.APP_OPEN) && this.zzesr.zzdww && this.zzdjd != null && com.google.android.gms.ads.internal.zzr.zzlg().zzm(this.context)) {
            zzazn zzaznVar = this.zzbpn;
            int i2 = zzaznVar.zzehy;
            int i3 = zzaznVar.zzehz;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
            String sb2 = sb.toString();
            String videoEventsOwner = this.zzesr.zzhjr.getVideoEventsOwner();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvp)).booleanValue()) {
                if (this.zzesr.zzhjr.getMediaType() == OmidMediaType.VIDEO) {
                    zzarnVar = zzarn.VIDEO;
                    zzarmVar2 = zzarm.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzesr.zzhjs == 2) {
                        zzarmVar = zzarm.UNSPECIFIED;
                    } else {
                        zzarmVar = zzarm.BEGIN_TO_RENDER;
                    }
                    zzarmVar2 = zzarmVar;
                    zzarnVar = zzarn.HTML_DISPLAY;
                }
                this.zzfvs = com.google.android.gms.ads.internal.zzr.zzlg().zza(sb2, this.zzdjd.getWebView(), "", "javascript", videoEventsOwner, zzarmVar2, zzarnVar, this.zzesr.zzcht);
            } else {
                this.zzfvs = com.google.android.gms.ads.internal.zzr.zzlg().zza(sb2, this.zzdjd.getWebView(), "", "javascript", videoEventsOwner);
            }
            if (this.zzfvs == null || this.zzdjd.getView() == null) {
                return;
            }
            com.google.android.gms.ads.internal.zzr.zzlg().zza(this.zzfvs, this.zzdjd.getView());
            this.zzdjd.zzaq(this.zzfvs);
            com.google.android.gms.ads.internal.zzr.zzlg().zzab(this.zzfvs);
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvs)).booleanValue()) {
                this.zzdjd.zza("onSdkLoaded", new ArrayMap());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void onUserLeaveHint() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zza(com.google.android.gms.ads.internal.overlay.zzn zznVar) {
        this.zzfvs = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzq
    public final void zzvo() {
        zzbeb zzbebVar;
        if (this.zzfvs == null || (zzbebVar = this.zzdjd) == null) {
            return;
        }
        zzbebVar.zza("onSdkImpression", new ArrayMap());
    }
}
