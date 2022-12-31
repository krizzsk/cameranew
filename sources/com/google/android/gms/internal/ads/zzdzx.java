package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdzx implements Executor {
    private final /* synthetic */ Executor zziat;
    private final /* synthetic */ zzdyk zziau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzx(Executor executor, zzdyk zzdykVar) {
        this.zziat = executor;
        this.zziau = zzdykVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zziat.execute(runnable);
        } catch (RejectedExecutionException e2) {
            this.zziau.setException(e2);
        }
    }
}
