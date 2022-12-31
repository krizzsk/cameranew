package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzaey;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@Deprecated
/* loaded from: classes2.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbob = new WeakHashMap<>();
    private zzaey a;
    private WeakReference<View> b;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        q.k(view, "ContainerView must not be null");
        if (!(view instanceof NativeAdView) && !(view instanceof UnifiedNativeAdView)) {
            if (zzbob.get(view) != null) {
                zzazk.zzev("The provided containerView is already in use with another NativeAdViewHolder.");
                return;
            }
            zzbob.put(view, this);
            this.b = new WeakReference<>(view);
            this.a = zzwr.zzqo().zza(view, b(map), b(map2));
            return;
        }
        zzazk.zzev("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
    }

    private final void a(com.google.android.gms.dynamic.b bVar) {
        WeakReference<View> weakReference = this.b;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzazk.zzex("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbob.containsKey(view)) {
            zzbob.put(view, this);
        }
        zzaey zzaeyVar = this.a;
        if (zzaeyVar != null) {
            try {
                zzaeyVar.zza(bVar);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call setNativeAd on delegate", e2);
            }
        }
    }

    private static HashMap<String, View> b(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.a.zzf(com.google.android.gms.dynamic.d.z0(view));
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        a((com.google.android.gms.dynamic.b) nativeAd.zzjs());
    }

    public final void unregisterNativeAd() {
        zzaey zzaeyVar = this.a;
        if (zzaeyVar != null) {
            try {
                zzaeyVar.unregisterNativeAd();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call unregisterNativeAd on delegate", e2);
            }
        }
        WeakReference<View> weakReference = this.b;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbob.remove(view);
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        a((com.google.android.gms.dynamic.b) unifiedNativeAd.zzjs());
    }
}
