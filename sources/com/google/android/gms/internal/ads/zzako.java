package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.p;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzako implements zzakl, zzakm {
    private final zzbeb zzdjd;

    public zzako(Context context, zzazn zzaznVar, @Nullable zzei zzeiVar, com.google.android.gms.ads.internal.zzb zzbVar) throws zzben {
        com.google.android.gms.ads.internal.zzr.zzks();
        zzbeb zza = zzbej.zza(context, zzbft.zzael(), "", false, false, zzeiVar, null, zzaznVar, null, null, null, zztu.zznf(), null, null);
        this.zzdjd = zza;
        zza.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwr.zzqn();
        if (zzaza.zzzx()) {
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final void destroy() {
        this.zzdjd.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final boolean isDestroyed() {
        return this.zzdjd.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzalx
    public final void zza(String str, zzaif<? super zzalx> zzaifVar) {
        this.zzdjd.zza(str, new zzakx(this, zzaifVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, Map map) {
        zzakk.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakl, com.google.android.gms.internal.ads.zzaki
    public final void zza(String str, JSONObject jSONObject) {
        zzakk.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalx
    public final void zzb(String str, final zzaif<? super zzalx> zzaifVar) {
        this.zzdjd.zza(str, new p(zzaifVar) { // from class: com.google.android.gms.internal.ads.zzakv
            private final zzaif zzdjh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdjh = zzaifVar;
            }

            @Override // com.google.android.gms.common.util.p
            public final boolean apply(Object obj) {
                zzaif zzaifVar2;
                zzaif zzaifVar3 = this.zzdjh;
                zzaif zzaifVar4 = (zzaif) obj;
                if (zzaifVar4 instanceof zzakx) {
                    zzaifVar2 = ((zzakx) zzaifVar4).zzdji;
                    return zzaifVar2.equals(zzaifVar3);
                }
                return false;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakw
    public final void zzb(String str, JSONObject jSONObject) {
        zzakk.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzakl, com.google.android.gms.internal.ads.zzakw
    public final void zzcv(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzakr
            private final zzako zzdje;
            private final String zzdjf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdje = this;
                this.zzdjf = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdje.zzdc(this.zzdjf);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final void zzcw(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        runOnUiThread(new Runnable(this, format) { // from class: com.google.android.gms.internal.ads.zzakq
            private final zzako zzdje;
            private final String zzdjf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdje = this;
                this.zzdjf = format;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdje.zzdb(this.zzdjf);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final void zzcx(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzaks
            private final zzako zzdje;
            private final String zzdjf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdje = this;
                this.zzdjf = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdje.zzcz(this.zzdjf);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final void zzcy(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzakt
            private final zzako zzdje;
            private final String zzdjf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdje = this;
                this.zzdjf = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdje.zzda(this.zzdjf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzcz(String str) {
        this.zzdjd.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzda(String str) {
        this.zzdjd.loadData(str, "text/html", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdb(String str) {
        this.zzdjd.loadData(str, "text/html", "UTF-8");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdc(String str) {
        this.zzdjd.zzcv(str);
    }

    @Override // com.google.android.gms.internal.ads.zzakl
    public final void zzi(String str, String str2) {
        zzakk.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final zzalw zzuj() {
        return new zzalz(this);
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final void zza(zzakp zzakpVar) {
        zzbfn zzacx = this.zzdjd.zzacx();
        zzakpVar.getClass();
        zzacx.zza(zzaku.zzb(zzakpVar));
    }
}
