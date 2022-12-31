package com.google.android.play.core.tasks;
/* loaded from: classes2.dex */
final class i implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k kVar, d dVar) {
        this.b = kVar;
        this.a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        b bVar;
        b bVar2;
        obj = this.b.b;
        synchronized (obj) {
            bVar = this.b.c;
            if (bVar != null) {
                bVar2 = this.b.c;
                bVar2.onFailure(this.a.f());
            }
        }
    }
}
