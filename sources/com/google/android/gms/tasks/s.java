package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class s implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, g gVar) {
        this.b = qVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        c cVar;
        c cVar2;
        obj = this.b.b;
        synchronized (obj) {
            cVar = this.b.c;
            if (cVar != null) {
                cVar2 = this.b.c;
                cVar2.onComplete(this.a);
            }
        }
    }
}
