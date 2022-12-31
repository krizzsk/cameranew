package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.o;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcsw implements zzcrj<zzbyy> {
    private final Context context;
    private final zzdmu zzfrb;
    private final Executor zzfsj;
    private final zzbzy zzgtz;

    public zzcsw(Context context, Executor executor, zzbzy zzbzyVar, zzdmu zzdmuVar) {
        this.context = context;
        this.zzgtz = zzbzyVar;
        this.zzfsj = executor;
        this.zzfrb = zzdmuVar;
    }

    private static String zze(zzdmw zzdmwVar) {
        try {
            return zzdmwVar.zzhjj.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final boolean zza(zzdnl zzdnlVar, zzdmw zzdmwVar) {
        return (this.context instanceof Activity) && o.b() && zzacp.zzj(this.context) && !TextUtils.isEmpty(zze(zzdmwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcrj
    public final zzdzw<zzbyy> zzb(final zzdnl zzdnlVar, final zzdmw zzdmwVar) {
        String zze = zze(zzdmwVar);
        final Uri parse = zze != null ? Uri.parse(zze) : null;
        return zzdzk.zzb(zzdzk.zzag(null), new zzdyu(this, parse, zzdnlVar, zzdmwVar) { // from class: com.google.android.gms.internal.ads.zzcsv
            private final zzdnl zzgtc;
            private final zzcsw zzgtw;
            private final Uri zzgtx;
            private final zzdmw zzgty;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgtw = this;
                this.zzgtx = parse;
                this.zzgtc = zzdnlVar;
                this.zzgty = zzdmwVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgtw.zza(this.zzgtx, this.zzgtc, this.zzgty, obj);
            }
        }, this.zzfsj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(Uri uri, zzdnl zzdnlVar, zzdmw zzdmwVar, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzd zzdVar = new com.google.android.gms.ads.internal.overlay.zzd(build.intent, null);
            final zzbaa zzbaaVar = new zzbaa();
            zzbza zza = this.zzgtz.zza(new zzboj(zzdnlVar, zzdmwVar, null), new zzbyz(new zzcag(zzbaaVar) { // from class: com.google.android.gms.internal.ads.zzcsy
                private final zzbaa zzbwd;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzbwd = zzbaaVar;
                }

                @Override // com.google.android.gms.internal.ads.zzcag
                public final void zza(boolean z, Context context) {
                    zzbaa zzbaaVar2 = this.zzbwd;
                    try {
                        com.google.android.gms.ads.internal.zzr.zzkq();
                        com.google.android.gms.ads.internal.overlay.zzm.zza(context, (AdOverlayInfoParcel) zzbaaVar2.get(), true);
                    } catch (Exception unused) {
                    }
                }
            }));
            zzbaaVar.set(new AdOverlayInfoParcel(zzdVar, null, zza.zzaia(), null, new zzazn(0, 0, false), null));
            this.zzfrb.zzxo();
            return zzdzk.zzag(zza.zzahz());
        } catch (Throwable th) {
            zzazk.zzc("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
