package kotlinx.coroutines;
/* compiled from: CompletionState.kt */
/* loaded from: classes3.dex */
public final class d0 {
    public final Object a;
    public final kotlin.jvm.b.l<Throwable, kotlin.u> b;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(Object obj, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar) {
        this.a = obj;
        this.b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            return kotlin.jvm.internal.s.c(this.a, d0Var.a) && kotlin.jvm.internal.s.c(this.b, d0Var.b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.a + ", onCancellation=" + this.b + ')';
    }
}
