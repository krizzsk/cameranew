package kotlinx.coroutines.internal;
/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public final class o {
    private static final Object a = new c0("CONDITION_FALSE");
    private static final Object b = new c0("LIST_EMPTY");

    public static final Object a() {
        return a;
    }

    public static final Object b() {
        return b;
    }

    public static final p c(Object obj) {
        x xVar = obj instanceof x ? (x) obj : null;
        return xVar == null ? (p) obj : xVar.a;
    }
}
