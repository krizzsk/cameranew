package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzdza<T> extends zzdzs<T> {
    private final Executor zziag;
    private final /* synthetic */ zzdyy zziah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdza(zzdyy zzdyyVar, Executor executor) {
        this.zziah = zzdyyVar;
        this.zziag = (Executor) zzdwl.checkNotNull(executor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zziag.execute(this);
        } catch (RejectedExecutionException e2) {
            this.zziah.setException(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdzs
    final boolean isDone() {
        return this.zziah.isDone();
    }

    abstract void setValue(T t);

    @Override // com.google.android.gms.internal.ads.zzdzs
    final void zzb(T t, Throwable th) {
        this.zziah.zziaf = null;
        if (th != null) {
            if (th instanceof ExecutionException) {
                this.zziah.setException(th.getCause());
                return;
            } else if (th instanceof CancellationException) {
                this.zziah.cancel(false);
                return;
            } else {
                this.zziah.setException(th);
                return;
            }
        }
        setValue(t);
    }
}
