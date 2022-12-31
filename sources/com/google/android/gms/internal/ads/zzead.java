package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzead<V> extends zzdze<V> {
    @NullableDecl
    private zzdzw<V> zziaz;
    @NullableDecl
    private ScheduledFuture<?> zziba;

    private zzead(zzdzw<V> zzdzwVar) {
        this.zziaz = (zzdzw) zzdwl.checkNotNull(zzdzwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzdzw<V> zzb(zzdzw<V> zzdzwVar, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzead zzeadVar = new zzead(zzdzwVar);
        zzeaf zzeafVar = new zzeaf(zzeadVar);
        zzeadVar.zziba = scheduledExecutorService.schedule(zzeafVar, j2, timeUnit);
        zzdzwVar.addListener(zzeafVar, zzdzd.INSTANCE);
        return zzeadVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final void afterDone() {
        maybePropagateCancellationTo(this.zziaz);
        ScheduledFuture<?> scheduledFuture = this.zziba;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zziaz = null;
        this.zziba = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final String pendingToString() {
        zzdzw<V> zzdzwVar = this.zziaz;
        ScheduledFuture<?> scheduledFuture = this.zziba;
        if (zzdzwVar != null) {
            String valueOf = String.valueOf(zzdzwVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("]");
            String sb2 = sb.toString();
            if (scheduledFuture != null) {
                long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                if (delay > 0) {
                    String valueOf2 = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 43);
                    sb3.append(valueOf2);
                    sb3.append(", remaining delay=[");
                    sb3.append(delay);
                    sb3.append(" ms]");
                    return sb3.toString();
                }
                return sb2;
            }
            return sb2;
        }
        return null;
    }
}
