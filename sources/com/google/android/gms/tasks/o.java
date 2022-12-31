package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class o implements Runnable {
    private final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.a.b;
        synchronized (obj) {
            bVar = this.a.c;
            if (bVar != null) {
                bVar2 = this.a.c;
                bVar2.onCanceled();
            }
        }
    }
}
