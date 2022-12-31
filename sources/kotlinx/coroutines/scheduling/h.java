package kotlinx.coroutines.scheduling;
/* compiled from: Tasks.kt */
/* loaded from: classes3.dex */
public abstract class h implements Runnable {
    public long a;
    public i b;

    public h(long j2, i iVar) {
        this.a = j2;
        this.b = iVar;
    }

    public h() {
        this(0L, f.a);
    }
}
