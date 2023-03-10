package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeah<V> extends zzdze<V> implements RunnableFuture<V> {
    private volatile zzdzs<?> zzibc;

    private zzeah(Callable<V> callable) {
        this.zzibc = new zzeaj(this, callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzeah<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzeah<>(Executors.callable(runnable, v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> zzeah<V> zzf(Callable<V> callable) {
        return new zzeah<>(callable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final void afterDone() {
        zzdzs<?> zzdzsVar;
        super.afterDone();
        if (wasInterrupted() && (zzdzsVar = this.zzibc) != null) {
            zzdzsVar.interruptTask();
        }
        this.zzibc = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdyk
    public final String pendingToString() {
        zzdzs<?> zzdzsVar = this.zzibc;
        if (zzdzsVar != null) {
            String valueOf = String.valueOf(zzdzsVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
            sb.append("task=[");
            sb.append(valueOf);
            sb.append("]");
            return sb.toString();
        }
        return super.pendingToString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzdzs<?> zzdzsVar = this.zzibc;
        if (zzdzsVar != null) {
            zzdzsVar.run();
        }
        this.zzibc = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeah(zzdyv<V> zzdyvVar) {
        this.zzibc = new zzeak(this, zzdyvVar);
    }
}
