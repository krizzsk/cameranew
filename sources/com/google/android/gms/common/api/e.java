package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.g;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class e<R extends g> {

    /* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Status status);
    }

    public void addStatusListener(@NonNull a aVar) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract R await();

    @NonNull
    public abstract R await(long j2, @NonNull TimeUnit timeUnit);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract void setResultCallback(@NonNull h<? super R> hVar);

    public abstract void setResultCallback(@NonNull h<? super R> hVar, long j2, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends g> k<S> then(@NonNull j<? super R, ? extends S> jVar) {
        throw new UnsupportedOperationException();
    }

    @Nullable
    public Integer zal() {
        throw new UnsupportedOperationException();
    }
}
