package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbkm implements zzqw {
    private final Clock zzbqg;
    private zzbeb zzdjd;
    private final zzbjx zzfsg;
    private final Executor zzfsj;
    private boolean zzbwh = false;
    private boolean zzftg = false;
    private zzbkb zzfsl = new zzbkb();

    public zzbkm(Executor executor, zzbjx zzbjxVar, Clock clock) {
        this.zzfsj = executor;
        this.zzfsg = zzbjxVar;
        this.zzbqg = clock;
    }

    private final void zzajb() {
        try {
            final JSONObject zzi = this.zzfsg.zzi(this.zzfsl);
            if (this.zzdjd != null) {
                this.zzfsj.execute(new Runnable(this, zzi) { // from class: com.google.android.gms.internal.ads.zzbkl
                    private final JSONObject zzfst;
                    private final zzbkm zzftf;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzftf = this;
                        this.zzfst = zzi;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzftf.zzi(this.zzfst);
                    }
                });
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zza("Failed to call video active view js", e2);
        }
    }

    public final void disable() {
        this.zzbwh = false;
    }

    public final void enable() {
        this.zzbwh = true;
        zzajb();
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        zzbkb zzbkbVar = this.zzfsl;
        zzbkbVar.zzbrj = this.zzftg ? false : zzqxVar.zzbrj;
        zzbkbVar.timestamp = this.zzbqg.a();
        this.zzfsl.zzfss = zzqxVar;
        if (this.zzbwh) {
            zzajb();
        }
    }

    public final void zzbf(boolean z) {
        this.zzftg = z;
    }

    public final void zzd(zzbeb zzbebVar) {
        this.zzdjd = zzbebVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdjd.zzb("AFMA_updateActiveView", jSONObject);
    }
}
