package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class x implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(y yVar, g gVar) {
        this.b = yVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        try {
            fVar = this.b.b;
            g then = fVar.then(this.a.j());
            if (then == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = i.b;
            then.d(executor, this.b);
            then.c(executor, this.b);
            then.a(executor, this.b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.b.onFailure((Exception) e2.getCause());
            } else {
                this.b.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.b.onCanceled();
        } catch (Exception e3) {
            this.b.onFailure(e3);
        }
    }
}
