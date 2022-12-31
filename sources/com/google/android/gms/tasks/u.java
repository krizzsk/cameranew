package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class u<TResult> implements a0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private d c;

    public u(@NonNull Executor executor, @NonNull d dVar) {
        this.a = executor;
        this.c = dVar;
    }

    @Override // com.google.android.gms.tasks.a0
    public final void a(@NonNull g<TResult> gVar) {
        if (gVar.n() || gVar.l()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new t(this, gVar));
        }
    }
}
