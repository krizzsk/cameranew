package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.p0;
/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public final class j extends h {
    public final Runnable c;

    public j(Runnable runnable, long j2, i iVar) {
        super(j2, iVar);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.c.run();
        } finally {
            this.b.v();
        }
    }

    public String toString() {
        return "Task[" + p0.a(this.c) + '@' + p0.b(this.c) + ", " + this.a + ", " + this.b + ']';
    }
}
