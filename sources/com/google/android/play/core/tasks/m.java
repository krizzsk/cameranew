package com.google.android.play.core.tasks;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m<ResultT> implements n<ResultT> {
    private final Executor a;
    private final Object b = new Object();
    @Nullable
    private final c<? super ResultT> c;

    public m(Executor executor, c<? super ResultT> cVar) {
        this.a = executor;
        this.c = cVar;
    }

    @Override // com.google.android.play.core.tasks.n
    public final void a(d<ResultT> dVar) {
        if (dVar.i()) {
            synchronized (this.b) {
                if (this.c == null) {
                    return;
                }
                this.a.execute(new l(this, dVar));
            }
        }
    }
}
