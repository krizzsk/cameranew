package com.google.android.play.core.tasks;
/* loaded from: classes2.dex */
final class l implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar, d dVar) {
        this.b = mVar;
        this.a = dVar;
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
                cVar2.onSuccess(this.a.g());
            }
        }
    }
}
