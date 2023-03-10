package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyAuctionFlags;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdp {
    private final zzcgk zzgge;
    private final zzchq zzggk;
    private ViewTreeObserver.OnScrollChangedListener zzggn = null;

    public zzcdp(zzchq zzchqVar, zzcgk zzcgkVar) {
        this.zzggk = zzchqVar;
        this.zzgge = zzcgkVar;
    }

    public final View zza(@NonNull final View view, @NonNull final WindowManager windowManager) throws zzben {
        zzbeb zza = this.zzggk.zza(zzvs.zzqe(), null, null);
        View view2 = zza.getView();
        view2.setVisibility(4);
        VdsAgent.onSetViewVisibility(view2, 4);
        zza.getView().setContentDescription("policy_validator");
        zza.zza("/sendMessageToSdk", new zzaif(this) { // from class: com.google.android.gms.internal.ads.zzcds
            private final zzcdp zzggq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggq = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggq.zze((zzbeb) obj, map);
            }
        });
        zza.zza("/hideValidatorOverlay", new zzaif(this, windowManager, view) { // from class: com.google.android.gms.internal.ads.zzcdr
            private final zzcdp zzggq;
            private final WindowManager zzggr;
            private final View zzggs;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggq = this;
                this.zzggr = windowManager;
                this.zzggs = view;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggq.zza(this.zzggr, this.zzggs, (zzbeb) obj, map);
            }
        });
        zza.zza("/open", new zzaij(null, null, null, null, null));
        this.zzgge.zza(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzaif(this, view, windowManager) { // from class: com.google.android.gms.internal.ads.zzcdu
            private final zzcdp zzggq;
            private final View zzggt;
            private final WindowManager zzggu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggq = this;
                this.zzggt = view;
                this.zzggu = windowManager;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                this.zzggq.zza(this.zzggt, this.zzggu, (zzbeb) obj, map);
            }
        });
        this.zzgge.zza(new WeakReference(zza), "/showValidatorOverlay", zzcdt.zzdhv);
        return zza.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "validatorHtmlLoaded");
        hashMap.put(TapjoyAuctionFlags.AUCTION_ID, (String) map.get(TapjoyAuctionFlags.AUCTION_ID));
        this.zzgge.zza("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbeb zzbebVar, Map map) {
        this.zzgge.zza("sendMessageToNativeJs", map);
    }

    private static int zza(Context context, String str, int i2) {
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzwr.zzqn();
        return zzaza.zze(context, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(final View view, final WindowManager windowManager, final zzbeb zzbebVar, final Map map) {
        int i2;
        zzbebVar.zzacx().zza(new zzbfq(this, map) { // from class: com.google.android.gms.internal.ads.zzcdv
            private final Map zzehx;
            private final zzcdp zzggq;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggq = this;
                this.zzehx = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbfq
            public final void zzal(boolean z) {
                this.zzggq.zzb(this.zzehx, z);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int zza = zza(context, (String) map.get("validator_width"), ((Integer) zzwr.zzqr().zzd(zzabp.zzczo)).intValue());
        int zza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzwr.zzqr().zzd(zzabp.zzczp)).intValue());
        int zza3 = zza(context, (String) map.get("validator_x"), 0);
        int zza4 = zza(context, (String) map.get("validator_y"), 0);
        zzbebVar.zza(zzbft.zzq(zza, zza2));
        try {
            zzbebVar.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwr.zzqr().zzd(zzabp.zzczq)).booleanValue());
            zzbebVar.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwr.zzqr().zzd(zzabp.zzczr)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams zzzq = com.google.android.gms.ads.internal.util.zzbn.zzzq();
        zzzq.x = zza3;
        zzzq.y = zza4;
        windowManager.updateViewLayout(zzbebVar.getView(), zzzq);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if (!"1".equals(str) && !"2".equals(str)) {
                i2 = rect.top;
            } else {
                i2 = rect.bottom;
            }
            final int i3 = i2 - zza4;
            this.zzggn = new ViewTreeObserver.OnScrollChangedListener(view, zzbebVar, str, zzzq, i3, windowManager) { // from class: com.google.android.gms.internal.ads.zzcdw
                private final String zzdlo;
                private final View zzggv;
                private final zzbeb zzggw;
                private final WindowManager.LayoutParams zzggx;
                private final int zzggy;
                private final WindowManager zzggz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzggv = view;
                    this.zzggw = zzbebVar;
                    this.zzdlo = str;
                    this.zzggx = zzzq;
                    this.zzggy = i3;
                    this.zzggz = windowManager;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    View view2 = this.zzggv;
                    zzbeb zzbebVar2 = this.zzggw;
                    String str2 = this.zzdlo;
                    WindowManager.LayoutParams layoutParams = this.zzggx;
                    int i4 = this.zzggy;
                    WindowManager windowManager2 = this.zzggz;
                    Rect rect2 = new Rect();
                    if (!view2.getGlobalVisibleRect(rect2) || zzbebVar2.getView().getWindowToken() == null) {
                        return;
                    }
                    if (!"1".equals(str2) && !"2".equals(str2)) {
                        layoutParams.y = rect2.top - i4;
                    } else {
                        layoutParams.y = rect2.bottom - i4;
                    }
                    windowManager2.updateViewLayout(zzbebVar2.getView(), layoutParams);
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzggn);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbebVar.loadUrl(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbeb zzbebVar, Map map) {
        zzazk.zzdy("Hide native ad policy validator overlay.");
        View view2 = zzbebVar.getView();
        view2.setVisibility(8);
        VdsAgent.onSetViewVisibility(view2, 8);
        if (zzbebVar.getView().getWindowToken() != null) {
            windowManager.removeView(zzbebVar.getView());
        }
        zzbebVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzggn == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzggn);
    }
}
