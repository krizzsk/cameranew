package kotlinx.coroutines;
/* compiled from: Job.kt */
/* loaded from: classes3.dex */
public final class i2 implements b1, v {
    public static final i2 a = new i2();

    private i2() {
    }

    @Override // kotlinx.coroutines.v
    public boolean c(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.b1
    public void dispose() {
    }

    @Override // kotlinx.coroutines.v
    public v1 getParent() {
        return null;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
