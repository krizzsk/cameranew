package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class m implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, g gVar) {
        this.b = kVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0 c0Var;
        c0 c0Var2;
        c0 c0Var3;
        a aVar;
        c0 c0Var4;
        c0 c0Var5;
        if (this.a.l()) {
            c0Var5 = this.b.c;
            c0Var5.s();
            return;
        }
        try {
            aVar = this.b.b;
            Object then = aVar.then(this.a);
            c0Var4 = this.b.c;
            c0Var4.r(then);
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
