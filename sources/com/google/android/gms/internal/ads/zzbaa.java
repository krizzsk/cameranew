package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class zzbaa<T> implements zzdzw<T> {
    private final zzeae<T> zzein = zzeae.zzbag();

    private static boolean zzat(boolean z) {
        if (!z) {
            com.google.android.gms.ads.internal.zzr.zzkv().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdzw
    public void addListener(Runnable runnable, Executor executor) {
        this.zzein.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.zzein.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.zzein.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.zzein.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.zzein.isDone();
    }

    public final boolean set(@Nullable T t) {
        return zzat(this.zzein.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzat(this.zzein.setException(th));
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzein.get(j2, timeUnit);
    }
}
