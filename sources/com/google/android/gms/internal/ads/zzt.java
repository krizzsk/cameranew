package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzt implements Executor {
    private final /* synthetic */ Handler val$handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar, Handler handler) {
        this.val$handler = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.val$handler.post(runnable);
    }
}
