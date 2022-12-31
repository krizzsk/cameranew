package kotlinx.coroutines;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class b0 {
    public final Object a;
    public final n b;
    public final kotlin.jvm.b.l<Throwable, kotlin.u> c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f8695d;

    /* renamed from: e  reason: collision with root package name */
    public final Throwable f8696e;

    /* JADX WARN: Multi-variable type inference failed */
    public b0(Object obj, n nVar, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Object obj2, Throwable th) {
        this.a = obj;
        this.b = nVar;
        this.c = lVar;
        this.f8695d = obj2;
        this.f8696e = th;
    }

    public static /* synthetic */ b0 b(b0 b0Var, Object obj, n nVar, kotlin.jvm.b.l lVar, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = b0Var.a;
        }
        if ((i2 & 2) != 0) {
            nVar = b0Var.b;
        }
        n nVar2 = nVar;
        kotlin.jvm.b.l<Throwable, kotlin.u> lVar2 = lVar;
        if ((i2 & 4) != 0) {
            lVar2 = b0Var.c;
        }
        kotlin.jvm.b.l lVar3 = lVar2;
        if ((i2 & 8) != 0) {
            obj2 = b0Var.f8695d;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = b0Var.f8696e;
        }
        return b0Var.a(obj, nVar2, lVar3, obj4, th);
    }

    public final b0 a(Object obj, n nVar, kotlin.jvm.b.l<? super Throwable, kotlin.u> lVar, Object obj2, Throwable th) {
        return new b0(obj, nVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f8696e != null;
    }

    public final void d(q<?> qVar, Throwable th) {
        n nVar = this.b;
        if (nVar != null) {
            qVar.n(nVar, th);
        }
        kotlin.jvm.b.l<Throwable, kotlin.u> lVar = this.c;
        if (lVar == null) {
            return;
        }
        qVar.o(lVar, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            return kotlin.jvm.internal.s.c(this.a, b0Var.a) && kotlin.jvm.internal.s.c(this.b, b0Var.b) && kotlin.jvm.internal.s.c(this.c, b0Var.c) && kotlin.jvm.internal.s.c(this.f8695d, b0Var.f8695d) && kotlin.jvm.internal.s.c(this.f8696e, b0Var.f8696e);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        n nVar = this.b;
        int hashCode2 = (hashCode + (nVar == null ? 0 : nVar.hashCode())) * 31;
        kotlin.jvm.b.l<Throwable, kotlin.u> lVar = this.c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f8695d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f8696e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.f8695d + ", cancelCause=" + this.f8696e + ')';
    }

    public /* synthetic */ b0(Object obj, n nVar, kotlin.jvm.b.l lVar, Object obj2, Throwable th, int i2, kotlin.jvm.internal.o oVar) {
        this(obj, (i2 & 2) != 0 ? null : nVar, (i2 & 4) != 0 ? null : lVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }
}
