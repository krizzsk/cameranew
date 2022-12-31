package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class q<TResult> implements a0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private c<TResult> c;

    public q(@NonNull Executor executor, @NonNull c<TResult> cVar) {
        this.a = executor;
        this.c = cVar;
    }

    @Override // com.google.android.gms.tasks.a0
    public final void a(@NonNull g<TResult> gVar) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new s(this, gVar));
        }
    }
}
