package de.greenrobot.event;
/* compiled from: PendingPostQueue.java */
/* loaded from: classes3.dex */
final class g {
    private f a;
    private f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(f fVar) {
        try {
            if (fVar != null) {
                f fVar2 = this.b;
                if (fVar2 != null) {
                    fVar2.c = fVar;
                    this.b = fVar;
                } else if (this.a == null) {
                    this.b = fVar;
                    this.a = fVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } else {
                throw new NullPointerException("null cannot be enqueued");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized f b() {
        f fVar;
        fVar = this.a;
        if (fVar != null) {
            f fVar2 = fVar.c;
            this.a = fVar2;
            if (fVar2 == null) {
                this.b = null;
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized f c(int i2) throws InterruptedException {
        if (this.a == null) {
            wait(i2);
        }
        return b();
    }
}
