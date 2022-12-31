package kotlinx.coroutines.channels;
/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public final class h<T> {
    public static final b b = new b(null);
    private static final c c = new c();
    private final Object a;

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c {
        public final Throwable a;

        public a(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.s.c(this.a, ((a) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.h.c
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            a aVar = new a(th);
            h.c(aVar);
            return aVar;
        }

        public final <E> Object b() {
            c cVar = h.c;
            h.c(cVar);
            return cVar;
        }

        public final <E> Object c(E e2) {
            h.c(e2);
            return e2;
        }
    }

    /* compiled from: Channel.kt */
    /* loaded from: classes3.dex */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ h(Object obj) {
        this.a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && kotlin.jvm.internal.s.c(obj, ((h) obj2).l());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar == null) {
            return null;
        }
        return aVar.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T f(Object obj) {
        if (obj instanceof c) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T g(Object obj) {
        Throwable th;
        if (obj instanceof c) {
            if (!(obj instanceof a) || (th = ((a) obj).a) == null) {
                throw new IllegalStateException(kotlin.jvm.internal.s.q("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
            }
            throw th;
        }
        return obj;
    }

    public static int h(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean i(Object obj) {
        return obj instanceof a;
    }

    public static final boolean j(Object obj) {
        return !(obj instanceof c);
    }

    public static String k(Object obj) {
        if (obj instanceof a) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.a, obj);
    }

    public int hashCode() {
        return h(this.a);
    }

    public final /* synthetic */ Object l() {
        return this.a;
    }

    public String toString() {
        return k(this.a);
    }
}
