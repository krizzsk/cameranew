package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class n implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, g gVar) {
        this.b = lVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        a aVar;
        try {
            aVar = this.b.b;
            g gVar = (g) aVar.then(this.a);
            if (gVar == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = i.b;
            gVar.d(executor, this.b);
            gVar.c(executor, this.b);
            gVar.a(executor, this.b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                c0Var3 = this.b.c;
                c0Var3.q((Exception) e2.getCause());
                return;
            }
            c0Var2 = this.b.c;
            c0Var2.q(e2);
        } catch (Exception e3) {
            c0Var = this.b.c;
            c0Var.q(e3);
        }
    }
}
