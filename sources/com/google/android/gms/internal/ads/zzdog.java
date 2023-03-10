package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.d;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdog {
    private final zzanj zzhlq;

    public zzdog(zzanj zzanjVar) {
        this.zzhlq = zzanjVar;
    }

    public final void destroy() throws zzdnt {
        try {
            this.zzhlq.destroy();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final zzzc getVideoController() throws zzdnt {
        try {
            return this.zzhlq.getVideoController();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final View getView() throws zzdnt {
        try {
            return (View) d.y0(this.zzhlq.zzuu());
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final boolean isInitialized() throws zzdnt {
        try {
            return this.zzhlq.isInitialized();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void onContextChanged(Context context) throws zzdnt {
        try {
            this.zzhlq.zzs(d.z0(context));
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void pause() throws zzdnt {
        try {
            this.zzhlq.pause();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void resume() throws zzdnt {
        try {
            this.zzhlq.resume();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void setImmersiveMode(boolean z) throws zzdnt {
        try {
            this.zzhlq.setImmersiveMode(z);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void showInterstitial() throws zzdnt {
        try {
            this.zzhlq.showInterstitial();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void showVideo() throws zzdnt {
        try {
            this.zzhlq.showVideo();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvs zzvsVar, zzvl zzvlVar, String str, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvsVar, zzvlVar, str, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zzb(Context context, zzvl zzvlVar, String str, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zzb(d.z0(context), zzvlVar, str, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zzc(Context context, zzvl zzvlVar, String str, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zzc(d.z0(context), zzvlVar, str, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zzci(Context context) throws zzdnt {
        try {
            this.zzhlq.zzt(d.z0(context));
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final zzanr zzuv() throws zzdnt {
        try {
            return this.zzhlq.zzuv();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final zzans zzuw() throws zzdnt {
        try {
            return this.zzhlq.zzuw();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final boolean zzuz() throws zzdnt {
        try {
            return this.zzhlq.zzuz();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final zzanx zzvb() throws zzdnt {
        try {
            return this.zzhlq.zzvb();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    @Nullable
    public final zzapy zzvc() throws zzdnt {
        try {
            return this.zzhlq.zzvc();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    @Nullable
    public final zzapy zzvd() throws zzdnt {
        try {
            return this.zzhlq.zzvd();
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvl zzvlVar, String str, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvlVar, str, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvs zzvsVar, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvsVar, zzvlVar, str, str2, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvl zzvlVar, String str, String str2, zzank zzankVar) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvlVar, str, str2, zzankVar);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvl zzvlVar, String str, zzavf zzavfVar, String str2) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvlVar, (String) null, zzavfVar, str2);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(zzvl zzvlVar, String str) throws zzdnt {
        try {
            this.zzhlq.zza(zzvlVar, str);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzvl zzvlVar, String str, String str2, zzank zzankVar, zzaeh zzaehVar, List<String> list) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzvlVar, str, str2, zzankVar, zzaehVar, list);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzavf zzavfVar, List<String> list) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzavfVar, list);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final void zza(Context context, zzajj zzajjVar, List<zzajr> list) throws zzdnt {
        try {
            this.zzhlq.zza(d.z0(context), zzajjVar, list);
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }
}
