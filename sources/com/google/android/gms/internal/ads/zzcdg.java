package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.messaging.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyAuctionFlags;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcdg implements View.OnClickListener {
    private final Clock zzbqg;
    private final zzcgk zzgge;
    @Nullable
    private zzagm zzggf;
    @Nullable
    private zzaif<Object> zzggg;
    @Nullable
    @VisibleForTesting
    String zzggh;
    @Nullable
    @VisibleForTesting
    Long zzggi;
    @Nullable
    @VisibleForTesting
    WeakReference<View> zzggj;

    public zzcdg(zzcgk zzcgkVar, Clock clock) {
        this.zzgge = zzcgkVar;
        this.zzbqg = clock;
    }

    private final void zzape() {
        View view;
        this.zzggh = null;
        this.zzggi = null;
        WeakReference<View> weakReference = this.zzggj;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzggj = null;
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzggf == null || this.zzggi == null) {
            return;
        }
        zzape();
        try {
            this.zzggf.onUnconfirmedClickCancelled();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        VdsAgent.onClick(this, view);
        WeakReference<View> weakReference = this.zzggj;
        if (weakReference == null || weakReference.get() != view) {
            return;
        }
        if (this.zzggh != null && this.zzggi != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TapjoyAuctionFlags.AUCTION_ID, this.zzggh);
            hashMap.put("time_interval", String.valueOf(this.zzbqg.currentTimeMillis() - this.zzggi.longValue()));
            hashMap.put(Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE, "onePointFiveClick");
            this.zzgge.zza("sendMessageToNativeJs", hashMap);
        }
        zzape();
    }

    public final void zza(final zzagm zzagmVar) {
        this.zzggf = zzagmVar;
        zzaif<Object> zzaifVar = this.zzggg;
        if (zzaifVar != null) {
            this.zzgge.zzb("/unconfirmedClick", zzaifVar);
        }
        zzaif<Object> zzaifVar2 = new zzaif(this, zzagmVar) { // from class: com.google.android.gms.internal.ads.zzcdf
            private final zzcdg zzggc;
            private final zzagm zzggd;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzggc = this;
                this.zzggd = zzagmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaif
            public final void zza(Object obj, Map map) {
                zzcdg zzcdgVar = this.zzggc;
                zzagm zzagmVar2 = this.zzggd;
                try {
                    zzcdgVar.zzggi = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzazk.zzev("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzcdgVar.zzggh = (String) map.get(TapjoyAuctionFlags.AUCTION_ID);
                String str = (String) map.get("asset_id");
                if (zzagmVar2 == null) {
                    zzazk.zzdy("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzagmVar2.onUnconfirmedClickReceived(str);
                } catch (RemoteException e2) {
                    zzazk.zze("#007 Could not call remote method.", e2);
                }
            }
        };
        this.zzggg = zzaifVar2;
        this.zzgge.zza("/unconfirmedClick", zzaifVar2);
    }

    @Nullable
    public final zzagm zzapd() {
        return this.zzggf;
    }
}
