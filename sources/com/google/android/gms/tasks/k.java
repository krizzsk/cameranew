package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class k<TResult, TContinuationResult> implements a0<TResult> {
    private final Executor a;
    private final a<TResult, TContinuationResult> b;
    private final c0<TContinuationResult> c;

    public k(@NonNull Executor executor, @NonNull a<TResult, TContinuationResult> aVar, @NonNull c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = aVar;
        this.c = c0Var;
    }

    @Override // com.google.android.gms.tasks.a0
    public final void a(@NonNull g<TResult> gVar) {
        this.a.execute(new m(this, gVar));
    }
}
