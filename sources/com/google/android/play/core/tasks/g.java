package com.google.android.play.core.tasks;
/* loaded from: classes2.dex */
final class g implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, d dVar) {
        this.b = hVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        a aVar;
        a aVar2;
        obj = this.b.b;
        synchronized (obj) {
            aVar = this.b.c;
            if (aVar != null) {
                aVar2 = this.b.c;
                aVar2.onComplete(this.a);
            }
        }
    }
}
