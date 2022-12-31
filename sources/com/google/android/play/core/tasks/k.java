package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k<ResultT> implements n<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    @Nullable
    private final b c;

    public k(Executor executor, b bVar) {
        this.a = executor;
        this.c = bVar;
    }

    @Override // com.google.android.play.core.tasks.n
    public final void a(d<ResultT> dVar) {
        if (dVar.i()) {
            return;
        }
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            this.a.execute(new i(this, dVar));
        }
    }
}
