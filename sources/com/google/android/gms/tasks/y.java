package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class y<TResult, TContinuationResult> implements b, d, e<TContinuationResult>, a0<TResult> {
    private final Executor a;
    private final f<TResult, TContinuationResult> b;
    private final c0<TContinuationResult> c;

    public y(@NonNull Executor executor, @NonNull f<TResult, TContinuationResult> fVar, @NonNull c0<TContinuationResult> c0Var) {
        this.a = executor;
        this.b = fVar;
        this.c = c0Var;
    }

    @Override // com.google.android.gms.tasks.a0
    public final void a(@NonNull g<TResult> gVar) {
        this.a.execute(new x(this, gVar));
    }

    @Override // com.google.android.gms.tasks.b
    public final void onCanceled() {
        this.c.s();
    }

    @Override // com.google.android.gms.tasks.d
    public final void onFailure(@NonNull Exception exc) {
        this.c.q(exc);
    }

    @Override // com.google.android.gms.tasks.e
    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.c.r(tcontinuationresult);
    }
}
