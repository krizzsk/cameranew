package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.b;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbnm implements zzbse, zzbtb {
    private final Context context;
    private final zzazn zzbpn;
    @Nullable
    private final zzbeb zzdjd;
    private final zzdmw zzesr;
    @Nullable
    @GuardedBy("this")
    private b zzfvs;
    @GuardedBy("this")
    private boolean zzfvt;

    public zzbnm(Context context, @Nullable zzbeb zzbebVar, zzdmw zzdmwVar, zzazn zzaznVar) {
        this.context = context;
        this.zzdjd = zzbebVar;
        this.zzesr = zzdmwVar;
        this.zzbpn = zzaznVar;
    }

    private final synchronized void zzakn() {
        zzarn zzarnVar;
        zzarm zzarmVar;
        if (this.zzesr.zzdww) {
            if (this.zzdjd == null) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzr.zzlg().zzm(this.context)) {
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
                        zzarmVar = zzarm.DEFINED_BY_JAVASCRIPT;
                    } else {
                        zzarnVar = zzarn.HTML_DISPLAY;
                        if (this.zzesr.zzhiz == 1) {
                            zzarmVar = zzarm.ONE_PIXEL;
                        } else {
                            zzarmVar = zzarm.BEGIN_TO_RENDER;
                        }
                    }
                    this.zzfvs = com.google.android.gms.ads.internal.zzr.zzlg().zza(sb2, this.zzdjd.getWebView(), "", "javascript", videoEventsOwner, zzarmVar, zzarnVar, this.zzesr.zzcht);
                } else {
                    this.zzfvs = com.google.android.gms.ads.internal.zzr.zzlg().zza(sb2, this.zzdjd.getWebView(), "", "javascript", videoEventsOwner);
                }
                View view = this.zzdjd.getView();
                if (this.zzfvs != null && view != null) {
                    com.google.android.gms.ads.internal.zzr.zzlg().zza(this.zzfvs, view);
                    this.zzdjd.zzaq(this.zzfvs);
                    com.google.android.gms.ads.internal.zzr.zzlg().zzab(this.zzfvs);
                    this.zzfvt = true;
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcvs)).booleanValue()) {
                        this.zzdjd.zza("onSdkLoaded", new ArrayMap());
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbse
    public final synchronized void onAdImpression() {
        zzbeb zzbebVar;
        if (!this.zzfvt) {
            zzakn();
        }
        if (this.zzesr.zzdww && this.zzfvs != null && (zzbebVar = this.zzdjd) != null) {
            zzbebVar.zza("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final synchronized void onAdLoaded() {
        if (this.zzfvt) {
            return;
        }
        zzakn();
    }
}
