package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StateFlow.kt */
/* loaded from: classes3.dex */
public final class StateFlowImpl<T> extends kotlinx.coroutines.flow.internal.a<j1> implements y0<T>, Object<T>, kotlinx.coroutines.flow.internal.k<T> {
    private volatile /* synthetic */ Object _state;

    /* renamed from: e  reason: collision with root package name */
    private int f8746e;

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    private final boolean o(Object obj, Object obj2) {
        int i2;
        j1[] l2;
        l();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !kotlin.jvm.internal.s.c(obj3, obj)) {
                return false;
            }
            if (kotlin.jvm.internal.s.c(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.f8746e;
            if ((i3 & 1) == 0) {
                int i4 = i3 + 1;
                this.f8746e = i4;
                j1[] l3 = l();
                kotlin.u uVar = kotlin.u.a;
                while (true) {
                    j1[] j1VarArr = l3;
                    if (j1VarArr != null) {
                        for (j1 j1Var : j1VarArr) {
                            if (j1Var != null) {
                                j1Var.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i2 = this.f8746e;
                        if (i2 == i4) {
                            this.f8746e = i4 + 1;
                            return true;
                        }
                        l2 = l();
                        kotlin.u uVar2 = kotlin.u.a;
                    }
                    l3 = l2;
                    i4 = i2;
                }
            } else {
                this.f8746e = i3 + 2;
                return true;
            }
        }
    }

    @Override // kotlinx.coroutines.flow.x0
    public boolean a(T t) {
        setValue(t);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.k
    public c<T> b(CoroutineContext coroutineContext, int i2, BufferOverflow bufferOverflow) {
        return i1.d(this, coroutineContext, i2, bufferOverflow);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
        if (kotlin.jvm.internal.s.c(r11, r12) == false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ab A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b0 A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:39:0x00b0, B:49:0x00d1, B:51:0x00d7, B:41:0x00b6, B:45:0x00bd, B:37:0x00ab, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:58:0x0024 }] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d5 -> B:34:0x00a6). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00e7 -> B:34:0x00a6). Please submit an issue!!! */
    @Override // kotlinx.coroutines.flow.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(kotlinx.coroutines.flow.d<? super T> r11, kotlin.coroutines.Continuation<? super kotlin.u> r12) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.d(kotlinx.coroutines.flow.d, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.d
    public Object emit(T t, Continuation<? super kotlin.u> continuation) {
        setValue(t);
        return kotlin.u.a;
    }

    @Override // kotlinx.coroutines.flow.y0
    public boolean f(T t, T t2) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.n.a;
        }
        if (t2 == null) {
            t2 = (T) kotlinx.coroutines.flow.internal.n.a;
        }
        return o(t, t2);
    }

    @Override // kotlinx.coroutines.flow.y0
    public T getValue() {
        kotlinx.coroutines.internal.c0 c0Var = kotlinx.coroutines.flow.internal.n.a;
        T t = (T) this._state;
        if (t == c0Var) {
            return null;
        }
        return t;
    }

    @Override // kotlinx.coroutines.flow.x0
    public void h() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: m */
    public j1 g() {
        return new j1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.a
    /* renamed from: n */
    public j1[] i(int i2) {
        return new j1[i2];
    }

    @Override // kotlinx.coroutines.flow.y0
    public void setValue(T t) {
        if (t == null) {
            t = (T) kotlinx.coroutines.flow.internal.n.a;
        }
        o(null, t);
    }
}
