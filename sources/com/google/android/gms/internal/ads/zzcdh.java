package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyAuctionFlags;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdh {
    private final zzccl zzgdh;
    private final zzcgk zzgge;
    private final zzchq zzggk;
    private final zzbkm zzggl;

    public zzcdh(zzchq zzchqVar, zzcgk zzcgkVar, zzbkm zzbkmVar, zzccl zzcclVar) {
        this.zzggk = zzchqVar;
        this.zzgge = zzcgkVar;
        this.zzggl = zzbkmVar;
        this.zzgdh = zzcclVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbeb zzbebVar, Map map) {
        zzazk.zzew("Hiding native ads overlay.");
        View view = zzbebVar.getView();
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
        this.zzggl.zzbf(false);
    }

    public final View zzapf() throws zzben {
        zzbeb zza = this.zzggk.zza(zzvs.zzqe(), null, null);
        View view = zza.getView();
        view.setVisibility(8);
        VdsAgent.onSetViewVisibility(view, 8);
        zza.zza("/sendMessageToSdk", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcdk
            private final zzcdh zzggm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggm.zzd((zzbeb) obj, map);
            }
        });
        zza.zza("/adMuted", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcdj
            private final zzcdh zzggm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggm.zzc((zzbeb) obj, map);
            }
        });
        this.zzgge.zza(new WeakReference(zza), "/loadHtml", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcdm
            private final zzcdh zzggm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, final Map map) {
                final zzcdh zzcdhVar = this.zzggm;
                zzbeb zzbebVar = (zzbeb) obj;
                zzbebVar.zzacx().zza(new zzbfq(zzcdhVar, map) { // from class: com.google.android.gms.internal.ads.zzcdn
                    private final Map zzehx;
                    private final zzcdh zzggm;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzggm = zzcdhVar;
                        this.zzehx = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbfq
                    public final void zzal(boolean z) {
                        this.zzggm.zza(this.zzehx, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbebVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzbebVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzgge.zza(new WeakReference(zza), "/showOverlay", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcdl
            private final zzcdh zzggm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggm.zzb((zzbeb) obj, map);
            }
        });
        this.zzgge.zza(new WeakReference(zza), "/hideOverlay", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcdo
            private final zzcdh zzggm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggm = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggm.zza((zzbeb) obj, map);
            }
        });
        return zza.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbeb zzbebVar, Map map) {
        zzazk.zzew("Showing native ads overlay.");
        View view = zzbebVar.getView();
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
        this.zzggl.zzbf(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbeb zzbebVar, Map map) {
        this.zzgdh.zzank();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbeb zzbebVar, Map map) {
        this.zzgge.zza("sendMessageToNativeJs", map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "htmlLoaded");
        hashMap.put(TapjoyAuctionFlags.AUCTION_ID, (String) map.get(TapjoyAuctionFlags.AUCTION_ID));
        this.zzgge.zza("sendMessageToNativeJs", hashMap);
    }
}
