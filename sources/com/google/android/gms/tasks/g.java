package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
public abstract class g<TResult> {
    @NonNull
    public g<TResult> a(@NonNull Executor executor, @NonNull b bVar) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    public g<TResult> b(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    public abstract g<TResult> c(@NonNull Executor executor, @NonNull d dVar);

    @NonNull
    public abstract g<TResult> d(@NonNull Executor executor, @NonNull e<? super TResult> eVar);

    @NonNull
    public <TContinuationResult> g<TContinuationResult> e(@NonNull a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> g<TContinuationResult> f(@NonNull Executor executor, @NonNull a<TResult, TContinuationResult> aVar) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    public <TContinuationResult> g<TContinuationResult> g(@NonNull a<TResult, g<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @NonNull
    public <TContinuationResult> g<TContinuationResult> h(@NonNull Executor executor, @NonNull a<TResult, g<TContinuationResult>> aVar) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @Nullable
    public abstract Exception i();

    public abstract TResult j();

    public abstract <X extends Throwable> TResult k(@NonNull Class<X> cls) throws Throwable;

    public abstract boolean l();

    public abstract boolean m();

    public abstract boolean n();

    @NonNull
    public <TContinuationResult> g<TContinuationResult> o(@NonNull f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @NonNull
    public <TContinuationResult> g<TContinuationResult> p(@NonNull Executor executor, @NonNull f<TResult, TContinuationResult> fVar) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
