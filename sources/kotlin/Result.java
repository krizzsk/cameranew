package kotlin;

import java.io.Serializable;
/* compiled from: Result.kt */
/* loaded from: classes3.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            kotlin.jvm.internal.s.h(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.s.c(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* compiled from: Result.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Result m40boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m41constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m42equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.s.c(obj, ((Result) obj2).m50unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m43equalsimpl0(Object obj, Object obj2) {
        return kotlin.jvm.internal.s.c(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m44exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    private static final T m45getOrNullimpl(Object obj) {
        if (m47isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m46hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl  reason: not valid java name */
    public static final boolean m47isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m48isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m49toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m42equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m46hashCodeimpl(this.value);
    }

    public String toString() {
        return m49toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m50unboximpl() {
        return this.value;
    }
}
