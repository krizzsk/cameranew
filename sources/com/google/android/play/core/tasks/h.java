package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
final class h<ResultT> implements n<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    @Nullable
    private final a<ResultT> c;

    public h(Executor executor, a<ResultT> aVar) {
        this.a = executor;
        this.c = aVar;
    }

    @Override // com.google.android.play.core.tasks.n
    public final void a(d<ResultT> dVar) {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new g(this, dVar));
        }
    }
}
