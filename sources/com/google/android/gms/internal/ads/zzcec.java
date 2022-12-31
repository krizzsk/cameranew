package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzcec implements zzccl {
    private final Context context;
    private final zzazn zzbpn;
    private final zzdmw zzesr;
    private final zzdnp zzfwy;
    private final zzbsd zzgci;
    private final zzbrl zzgcj;
    @Nullable
    private final zzanr zzghc;
    @Nullable
    private final zzans zzghd;
    @Nullable
    private final zzanx zzghe;
    private boolean zzgcn = false;
    private boolean zzgcq = false;
    private boolean zzghf = true;

    public zzcec(@Nullable zzanr zzanrVar, @Nullable zzans zzansVar, @Nullable zzanx zzanxVar, zzbsd zzbsdVar, zzbrl zzbrlVar, Context context, zzdmw zzdmwVar, zzazn zzaznVar, zzdnp zzdnpVar) {
        this.zzghc = zzanrVar;
        this.zzghd = zzansVar;
        this.zzghe = zzanxVar;
        this.zzgci = zzbsdVar;
        this.zzgcj = zzbrlVar;
        this.context = context;
        this.zzesr = zzdmwVar;
        this.zzbpn = zzaznVar;
        this.zzfwy = zzdnpVar;
    }

    private final void zzad(View view) {
        try {
            zzanx zzanxVar = this.zzghe;
            if (zzanxVar != null && !zzanxVar.getOverrideClickHandling()) {
                this.zzghe.zzu(d.z0(view));
                this.zzgcj.onAdClicked();
                return;
            }
            zzanr zzanrVar = this.zzghc;
            if (zzanrVar != null && !zzanrVar.getOverrideClickHandling()) {
                this.zzghc.zzu(d.z0(view));
                this.zzgcj.onAdClicked();
                return;
            }
            zzans zzansVar = this.zzghd;
            if (zzansVar == null || zzansVar.getOverrideClickHandling()) {
                return;
            }
            this.zzghd.zzu(d.z0(view));
            this.zzgcj.onAdClicked();
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to call handleClick", e2);
        }
    }

    private final Object zzapg() {
        b zzvh;
        zzanx zzanxVar = this.zzghe;
        if (zzanxVar != null) {
            try {
                zzvh = zzanxVar.zzvh();
            } catch (RemoteException unused) {
                return null;
            }
        } else {
            zzanr zzanrVar = this.zzghc;
            if (zzanrVar != null) {
                try {
                    zzvh = zzanrVar.zzvh();
                } catch (RemoteException unused2) {
                    return null;
                }
            } else {
                zzans zzansVar = this.zzghd;
                if (zzansVar != null) {
                    try {
                        zzvh = zzansVar.zzvh();
                    } catch (RemoteException unused3) {
                        return null;
                    }
                } else {
                    zzvh = null;
                }
            }
        }
        if (zzvh != null) {
            try {
                return d.y0(zzvh);
            } catch (IllegalArgumentException unused4) {
            }
        }
        return null;
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final boolean isCustomClickGestureEnabled() {
        return this.zzesr.zzdne;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    @Nullable
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            b z0 = d.z0(view);
            this.zzghf = zzb(map, map2);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            zzanx zzanxVar = this.zzghe;
            if (zzanxVar != null) {
                zzanxVar.zzc(z0, d.z0(zzb), d.z0(zzb2));
                return;
            }
            zzanr zzanrVar = this.zzghc;
            if (zzanrVar != null) {
                zzanrVar.zzc(z0, d.z0(zzb), d.z0(zzb2));
                this.zzghc.zzv(z0);
                return;
            }
            zzans zzansVar = this.zzghd;
            if (zzansVar != null) {
                zzansVar.zzc(z0, d.z0(zzb), d.z0(zzb2));
                this.zzghd.zzv(z0);
            }
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to call trackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(zzagm zzagmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzanj() {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzank() {
        zzazk.zzex("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzanl() {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzf(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzfw(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final boolean zzh(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zztx() {
        this.zzgcq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzb(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            boolean z = this.zzgcn;
            if (!z && this.zzesr.zzhjl != null) {
                this.zzgcn = z | com.google.android.gms.ads.internal.zzr.zzlb().zzb(this.context, this.zzbpn.zzbrp, this.zzesr.zzhjl.toString(), this.zzfwy.zzhkx);
            }
            if (this.zzghf) {
                zzanx zzanxVar = this.zzghe;
                if (zzanxVar != null && !zzanxVar.getOverrideImpressionRecording()) {
                    this.zzghe.recordImpression();
                    this.zzgci.onAdImpression();
                    return;
                }
                zzanr zzanrVar = this.zzghc;
                if (zzanrVar != null && !zzanrVar.getOverrideImpressionRecording()) {
                    this.zzghc.recordImpression();
                    this.zzgci.onAdImpression();
                    return;
                }
                zzans zzansVar = this.zzghd;
                if (zzansVar == null || zzansVar.getOverrideImpressionRecording()) {
                    return;
                }
                this.zzghd.recordImpression();
                this.zzgci.onAdImpression();
            }
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to call recordImpression", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            b z0 = d.z0(view);
            zzanx zzanxVar = this.zzghe;
            if (zzanxVar != null) {
                zzanxVar.zzw(z0);
                return;
            }
            zzanr zzanrVar = this.zzghc;
            if (zzanrVar != null) {
                zzanrVar.zzw(z0);
                return;
            }
            zzans zzansVar = this.zzghd;
            if (zzansVar != null) {
                zzansVar.zzw(z0);
            }
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to call untrackView", e2);
        }
    }

    private final boolean zzb(@Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        Object obj;
        JSONObject jSONObject = this.zzesr.zzhka;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrf)).booleanValue() && jSONObject.length() != 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            hashMap.putAll(map2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    WeakReference weakReference = (WeakReference) hashMap.get(next);
                    if (weakReference == null || (obj = weakReference.get()) == null) {
                        return false;
                    }
                    Class<?> cls = obj.getClass();
                    if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrg)).booleanValue() && next.equals("3010")) {
                        Object zzapg = zzapg();
                        if (zzapg == null) {
                            return false;
                        }
                        cls = zzapg.getClass();
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        com.google.android.gms.ads.internal.util.zzbh.zza(optJSONArray, arrayList);
                        com.google.android.gms.ads.internal.zzr.zzkr();
                        if (!com.google.android.gms.ads.internal.util.zzj.zza(this.context.getClassLoader(), cls, arrayList)) {
                            return false;
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzgcq && this.zzesr.zzdne) {
            return;
        }
        zzad(view);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgcq) {
            zzazk.zzex("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzesr.zzdne) {
            zzazk.zzex("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(@Nullable zzyn zzynVar) {
        zzazk.zzex("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zza(zzyj zzyjVar) {
        zzazk.zzex("Mute This Ad is not supported for 3rd party ads");
    }
}
