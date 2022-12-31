package kotlinx.coroutines;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class e1 implements p1 {
    private final boolean a;

    public e1(boolean z) {
        this.a = z;
    }

    @Override // kotlinx.coroutines.p1
    public h2 d() {
        return null;
    }

    @Override // kotlinx.coroutines.p1
    public boolean isActive() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
