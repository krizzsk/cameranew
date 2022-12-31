package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class w implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ v b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, g gVar) {
        this.b = vVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.b.b;
        synchronized (obj) {
            eVar = this.b.c;
            if (eVar != null) {
                eVar2 = this.b.c;
                eVar2.onSuccess(this.a.j());
            }
        }
    }
}
