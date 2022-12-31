package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class v<TResult> implements a0<TResult> {
    private final Executor a;
    private final Object b = new Object();
    @GuardedBy("mLock")
    private e<? super TResult> c;

    public v(@NonNull Executor executor, @NonNull e<? super TResult> eVar) {
        this.a = executor;
        this.c = eVar;
    }

    @Override // com.google.android.gms.tasks.a0
    public final void a(@NonNull g<TResult> gVar) {
        if (gVar.n()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new w(this, gVar));
            }
        }
    }
}
