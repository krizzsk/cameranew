package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.o;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzcbc implements zzccl {
    private final Context context;
    private final zzazn zzbpn;
    private final Clock zzbqg;
    private final zzei zzesm;
    private final zzdmw zzesr;
    private final zzdss zzfrf;
    private final zzcco zzfup;
    private final zzdnp zzfwy;
    private final JSONObject zzgcf;
    private final zzcgk zzgcg;
    private final zzccd zzgch;
    private final zzbsd zzgci;
    private final zzbrl zzgcj;
    private final zzbjz zzgck;
    private final zzcdg zzgcl;
    private final zzbxz zzgcm;
    private boolean zzgco;
    private zzyj zzgcv;
    private boolean zzgcn = false;
    private boolean zzgcp = false;
    private boolean zzgcq = false;
    private Point zzgcr = new Point();
    private Point zzgcs = new Point();
    private long zzgct = 0;
    private long zzgcu = 0;

    public zzcbc(Context context, zzcco zzccoVar, JSONObject jSONObject, zzcgk zzcgkVar, zzccd zzccdVar, zzei zzeiVar, zzbsd zzbsdVar, zzbrl zzbrlVar, zzdmw zzdmwVar, zzazn zzaznVar, zzdnp zzdnpVar, zzbjz zzbjzVar, zzcdg zzcdgVar, Clock clock, zzbxz zzbxzVar, zzdss zzdssVar) {
        this.context = context;
        this.zzfup = zzccoVar;
        this.zzgcf = jSONObject;
        this.zzgcg = zzcgkVar;
        this.zzgch = zzccdVar;
        this.zzesm = zzeiVar;
        this.zzgci = zzbsdVar;
        this.zzgcj = zzbrlVar;
        this.zzesr = zzdmwVar;
        this.zzbpn = zzaznVar;
        this.zzfwy = zzdnpVar;
        this.zzgck = zzbjzVar;
        this.zzgcl = zzcdgVar;
        this.zzbqg = clock;
        this.zzgcm = zzbxzVar;
        this.zzfrf = zzdssVar;
    }

    private final boolean zzani() {
        return this.zzgcf.optBoolean("allow_custom_click_gesture", false);
    }

    @Nullable
    private final String zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int zzanu = this.zzgch.zzanu();
        if (zzanu != 1) {
            if (zzanu != 2) {
                if (zzanu != 6) {
                    return null;
                }
                return "3099";
            }
            return "2099";
        }
        return "1099";
    }

    private final boolean zzfv(String str) {
        JSONObject optJSONObject = this.zzgcf.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    private final String zzx(View view) {
        try {
            JSONObject optJSONObject = this.zzgcf.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzesm.zzca().zza(this.context, optJSONObject.optString("click_string"), view);
        } catch (Exception e2) {
            zzazk.zzc("Exception obtaining click signals", e2);
            return null;
        }
    }

    private final String zzy(View view) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcsq)).booleanValue()) {
            try {
                return this.zzesm.zzca().zza(this.context, view, (Activity) null);
            } catch (Exception unused) {
                zzazk.zzev("Exception getting data.");
                return null;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void cancelUnconfirmedClick() {
        if (this.zzgcf.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzgcl.cancelUnconfirmedClick();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void destroy() {
        this.zzgcg.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final boolean isCustomClickGestureEnabled() {
        return zzani();
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void setClickConfirmingView(View view) {
        if (!this.zzgcf.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzazk.zzex("setClickConfirmingView: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcdg zzcdgVar = this.zzgcl;
        if (view != null) {
            view.setOnClickListener(zzcdgVar);
            view.setClickable(true);
            zzcdgVar.zzggj = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzgcr = new Point();
        this.zzgcs = new Point();
        if (!this.zzgco) {
            this.zzgcm.zzv(view);
            this.zzgco = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzgck.zzn(this);
        boolean zzdh = com.google.android.gms.ads.internal.util.zzbn.zzdh(this.zzbpn.zzehz);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view2 = entry.getValue().get();
                if (view2 != null) {
                    if (zzdh) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> entry2 : map2.entrySet()) {
                View view3 = entry2.getValue().get();
                if (view3 != null) {
                    if (zzdh) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzanj() {
        zza(null, null, null, null, null, null, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzank() {
        try {
            zzyj zzyjVar = this.zzgcv;
            if (zzyjVar != null) {
                zzyjVar.onAdMuted();
            }
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzanl() {
        q.e("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzgcf);
            zzazw.zza(this.zzgcg.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e2) {
            zzazk.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzf(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzazk.zzdy("Click data is null. No click is reported.");
        } else if (!zzfv("click_reporting")) {
            zzazk.zzev("The ad slot cannot handle external click events. You must be part of the allow list to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, com.google.android.gms.ads.internal.zzr.zzkr().zza(bundle, (JSONObject) null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzfw(String str) {
        zza(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzg(@Nullable Bundle bundle) {
        if (bundle == null) {
            zzazk.zzdy("Touch event data is null. No touch event is reported.");
        } else if (!zzfv("touch_reporting")) {
            zzazk.zzev("The ad slot cannot handle external touch events. You must be in the allow list to be able to report your touch events.");
        } else {
            int i2 = bundle.getInt("duration_ms");
            this.zzesm.zzca().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final boolean zzh(Bundle bundle) {
        if (!zzfv("impression_reporting")) {
            zzazk.zzev("The ad slot cannot handle external impression events. You must be in the allow list to be able to report your impression events.");
            return false;
        }
        return zza(null, null, null, null, null, com.google.android.gms.ads.internal.zzr.zzkr().zza(bundle, (JSONObject) null), false);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zztx() {
        this.zzgcq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        zza(com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view), com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view), com.google.android.gms.ads.internal.util.zzbn.zzt(view), com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view), zzy(view), null, com.google.android.gms.ads.internal.util.zzbn.zza(this.context, this.zzesr));
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        this.zzgcr = new Point();
        this.zzgcs = new Point();
        this.zzgcm.zzw(view);
        this.zzgco = false;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view2);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view2);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view2);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view2);
        String zzb2 = zzb(view, map);
        zza(((Boolean) zzwr.zzqr().zzd(zzabp.zzcsr)).booleanValue() ? view2 : view, zza2, zza, zzt, zzb, zzb2, com.google.android.gms.ads.internal.util.zzbn.zza(zzb2, this.context, this.zzgcs, this.zzgcr), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgcq) {
            zzazk.zzdy("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzani()) {
            zzazk.zzdy("Custom click reporting failed. Ad unit id not in the allow list.");
        } else {
            JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view);
            JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view);
            JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view);
            JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view);
            String zzb2 = zzb(null, map);
            zza(view, zza2, zza, zzt, zzb, zzb2, com.google.android.gms.ads.internal.util.zzbn.zza(zzb2, this.context, this.zzgcs, this.zzgcr), null, z, true);
        }
    }

    private final void zza(@Nullable View view, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, @Nullable JSONObject jSONObject6, boolean z, boolean z2) {
        q.e("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzgcf);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.zzfup.zzgb(this.zzgch.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzgch.zzanu());
            jSONObject8.put("view_aware_api_used", z);
            zzaeh zzaehVar = this.zzfwy.zzdoe;
            jSONObject8.put("custom_mute_requested", zzaehVar != null && zzaehVar.zzbnx);
            jSONObject8.put("custom_mute_enabled", (this.zzgch.getMuteThisAdReasons().isEmpty() || this.zzgch.zzanx() == null) ? false : true);
            if (this.zzgcl.zzapd() != null && this.zzgcf.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbqg.currentTimeMillis());
            if (this.zzgcq && zzani()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.zzfup.zzgb(this.zzgch.getCustomTemplateId()) != null);
            jSONObject8.put("click_signals", zzx(view));
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcuu)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdaj)).booleanValue() && o.n()) {
                jSONObject8.put("try_fallback_for_deep_link", true);
            }
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdak)).booleanValue() && o.n()) {
                jSONObject8.put("in_app_link_handling_for_android_11_enabled", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbqg.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzgct);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzgcu);
            jSONObject7.put("touch_signal", jSONObject9);
            zzazw.zza(this.zzgcg.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzazk.zzc("Unable to create click JSON.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(@Nullable View view, MotionEvent motionEvent, @Nullable View view2) {
        this.zzgcr = com.google.android.gms.ads.internal.util.zzbn.zza(motionEvent, view2);
        long currentTimeMillis = this.zzbqg.currentTimeMillis();
        this.zzgcu = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzgct = currentTimeMillis;
            this.zzgcs = this.zzgcr;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.zzgcr;
        obtain.setLocation(point.x, point.y);
        this.zzesm.zza(obtain);
        obtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    @Nullable
    public final JSONObject zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, map, map2, view);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, view);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(view);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zza);
            jSONObject.put("ad_view_signal", zza2);
            jSONObject.put("scroll_view_signal", zzt);
            jSONObject.put("lock_screen_signal", zzb);
            return jSONObject;
        } catch (JSONException e2) {
            zzazk.zzc("Unable to create native ad view signals JSON.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(zzagm zzagmVar) {
        if (!this.zzgcf.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzazk.zzex("setUnconfirmedClickListener: Your account need to be in the allow list to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzgcl.zza(zzagmVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(@Nullable zzyn zzynVar) {
        try {
            if (this.zzgcp) {
                return;
            }
            if (zzynVar == null && this.zzgch.zzanx() != null) {
                this.zzgcp = true;
                this.zzfrf.zzel(this.zzgch.zzanx().zzre());
                zzank();
                return;
            }
            this.zzgcp = true;
            this.zzfrf.zzel(zzynVar.zzre());
            zzank();
        } catch (RemoteException e2) {
            zzazk.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(zzyj zzyjVar) {
        this.zzgcv = zzyjVar;
    }

    private final boolean zza(@Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4, @Nullable String str, @Nullable JSONObject jSONObject5, boolean z) {
        q.e("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzgcf);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcsq)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", com.google.android.gms.ads.internal.util.zzbn.zzbk(this.context));
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdaf)).booleanValue()) {
                this.zzgcg.zza("/clickRecorded", new zzcbd(this));
            } else {
                this.zzgcg.zza("/logScionEvent", new zzcbe(this));
            }
            this.zzgcg.zza("/nativeImpression", new zzcbg(this));
            zzazw.zza(this.zzgcg.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z2 = this.zzgcn;
            if (z2 || this.zzesr.zzhjl == null) {
                return true;
            }
            this.zzgcn = z2 | com.google.android.gms.ads.internal.zzr.zzlb().zzb(this.context, this.zzbpn.zzbrp, this.zzesr.zzhjl.toString(), this.zzfwy.zzhkx);
            return true;
        } catch (JSONException e2) {
            zzazk.zzc("Unable to create impression JSON.", e2);
            return false;
        }
    }
}
