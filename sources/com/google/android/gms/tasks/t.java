package com.google.android.gms.tasks;
/* compiled from: com.google.android.gms:play-services-tasks@@17.1.0 */
/* loaded from: classes2.dex */
final class t implements Runnable {
    private final /* synthetic */ g a;
    private final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u uVar, g gVar) {
        this.b = uVar;
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.b.b;
        synchronized (obj) {
            dVar = this.b.c;
            if (dVar != null) {
                dVar2 = this.b.c;
                dVar2.onFailure(this.a.i());
            }
        }
    }
}
