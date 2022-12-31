package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzds implements zzdy {
    @Nullable
    private static zzds zzvn;
    private final Context context;
    private final zzdus zzvo;
    private final zzdux zzvp;
    private final zzdvc zzvq;
    private final zzex zzvr;
    private final zzdsy zzvs;
    private final Executor zzvt;
    private final zzgp zzvu;
    private final zzduy zzvv;
    @VisibleForTesting
    private volatile long zzvw = 0;
    private final Object zzvx = new Object();
    private volatile boolean zzvy;

    @VisibleForTesting
    private zzds(@NonNull Context context, @NonNull zzdsy zzdsyVar, @NonNull zzdus zzdusVar, @NonNull zzdux zzduxVar, @NonNull zzdvc zzdvcVar, @NonNull zzex zzexVar, @NonNull Executor executor, @NonNull zzdsx zzdsxVar, zzgp zzgpVar) {
        this.context = context;
        this.zzvs = zzdsyVar;
        this.zzvo = zzdusVar;
        this.zzvp = zzduxVar;
        this.zzvq = zzdvcVar;
        this.zzvr = zzexVar;
        this.zzvt = executor;
        this.zzvu = zzgpVar;
        this.zzvv = new zzdu(this, zzdsxVar);
    }

    public static synchronized zzds zza(@NonNull String str, @NonNull Context context, boolean z) {
        zzds zzdsVar;
        synchronized (zzds.class) {
            if (zzvn == null) {
                zzdtc zzaxo = zzdtc.zzaxr().zzhe(str).zzbo(z).zzaxo();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzds zza = zza(context, zzdsy.zza(context, newCachedThreadPool), zzaxo, newCachedThreadPool);
                zzvn = zza;
                zza.zzbq();
                zzvn.zzbt();
            }
            zzdsVar = zzvn;
        }
        return zzdsVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[Catch: zzelo -> 0x011f, TryCatch #0 {zzelo -> 0x011f, blocks: (B:6:0x0022, B:8:0x0033, B:11:0x0038, B:12:0x0044, B:14:0x0054, B:16:0x0062, B:19:0x006e, B:32:0x00a4, B:34:0x00b1, B:38:0x00ca, B:44:0x00e3, B:46:0x00f0, B:48:0x00f6, B:41:0x00d4, B:42:0x00db, B:22:0x0075, B:25:0x007c, B:27:0x008e, B:50:0x0105, B:52:0x0112), top: B:57:0x0022, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1 A[Catch: zzelo -> 0x011f, TryCatch #0 {zzelo -> 0x011f, blocks: (B:6:0x0022, B:8:0x0033, B:11:0x0038, B:12:0x0044, B:14:0x0054, B:16:0x0062, B:19:0x006e, B:32:0x00a4, B:34:0x00b1, B:38:0x00ca, B:44:0x00e3, B:46:0x00f0, B:48:0x00f6, B:41:0x00d4, B:42:0x00db, B:22:0x0075, B:25:0x007c, B:27:0x008e, B:50:0x0105, B:52:0x0112), top: B:57:0x0022, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzbs() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzds.zzbs():void");
    }

    private final zzdup zzp(int i2) {
        if (zzdue.zza(this.zzvu)) {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrr)).booleanValue()) {
                return this.zzvp.zzp(i2);
            }
            return this.zzvo.zzp(i2);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(int i2, int i3, int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zzb(View view) {
        this.zzvr.zzc(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzbq() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdup zzp = zzp(zzdva.zzhut);
        if (zzp != null) {
            this.zzvq.zzb(zzp);
        } else {
            this.zzvs.zzh(4013, System.currentTimeMillis() - currentTimeMillis);
        }
    }

    public final void zzbr() {
        if (zzdue.zza(this.zzvu)) {
            this.zzvt.execute(new zzdt(this));
        }
    }

    public final void zzbt() {
        if (this.zzvy) {
            return;
        }
        synchronized (this.zzvx) {
            if (!this.zzvy) {
                if ((System.currentTimeMillis() / 1000) - this.zzvw < 3600) {
                    return;
                }
                zzdup zzayw = this.zzvq.zzayw();
                if (zzayw == null || zzayw.zzff(3600L)) {
                    zzbr();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zzb(Context context) {
        zzbt();
        zzdte zzayv = this.zzvq.zzayv();
        if (zzayv != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzs = zzayv.zzs(context, null);
            this.zzvs.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzs, null);
            return zzs;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzds zza(@NonNull Context context, @NonNull zzdsy zzdsyVar, @NonNull zzdtc zzdtcVar) {
        return zza(context, zzdsyVar, zzdtcVar, Executors.newCachedThreadPool());
    }

    private static zzds zza(@NonNull Context context, @NonNull zzdsy zzdsyVar, @NonNull zzdtc zzdtcVar, @NonNull Executor executor) {
        zzdto zza = zzdto.zza(context, executor, zzdsyVar, zzdtcVar);
        zzfa zzfaVar = new zzfa(context);
        zzex zzexVar = new zzex(zzdtcVar, zza, new zzfj(context, zzfaVar), zzfaVar);
        zzgp zzayg = new zzdue(context, zzdsyVar).zzayg();
        zzdsx zzdsxVar = new zzdsx();
        return new zzds(context, zzdsyVar, new zzdus(context, zzayg), new zzdux(context, zzayg, new zzdr(zzdsyVar), ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrt)).booleanValue()), new zzdvc(context, zzexVar, zzdsyVar, zzdsxVar), zzexVar, executor, zzdsxVar, zzayg);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final void zza(MotionEvent motionEvent) {
        zzdte zzayv = this.zzvq.zzayv();
        if (zzayv != null) {
            try {
                zzayv.zza(null, motionEvent);
            } catch (zzduz e2) {
                this.zzvs.zza(e2.zzayu(), -1L, e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view, Activity activity) {
        zzbt();
        zzdte zzayv = this.zzvq.zzayv();
        if (zzayv != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zza = zzayv.zza(context, null, str, view, activity);
            this.zzvs.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, null);
            return zza;
        }
        return "";
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdy
    public final String zza(Context context, View view, Activity activity) {
        zzbt();
        zzdte zzayv = this.zzvq.zzayv();
        if (zzayv != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String zzb = zzayv.zzb(context, null, view, activity);
            this.zzvs.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, null);
            return zzb;
        }
        return "";
    }
}
