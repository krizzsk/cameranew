package kotlinx.coroutines;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class d2 {
    private static final kotlinx.coroutines.internal.c0 a = new kotlinx.coroutines.internal.c0("COMPLETING_ALREADY");
    public static final kotlinx.coroutines.internal.c0 b = new kotlinx.coroutines.internal.c0("COMPLETING_WAITING_CHILDREN");
    private static final kotlinx.coroutines.internal.c0 c = new kotlinx.coroutines.internal.c0("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.c0 f8732d = new kotlinx.coroutines.internal.c0("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.c0 f8733e = new kotlinx.coroutines.internal.c0("SEALED");

    /* renamed from: f  reason: collision with root package name */
    private static final e1 f8734f = new e1(false);

    /* renamed from: g  reason: collision with root package name */
    private static final e1 f8735g = new e1(true);

    public static final Object g(Object obj) {
        return obj instanceof p1 ? new q1((p1) obj) : obj;
    }

    public static final Object h(Object obj) {
        q1 q1Var = obj instanceof q1 ? (q1) obj : null;
        return q1Var == null ? obj : q1Var.a;
    }
}
