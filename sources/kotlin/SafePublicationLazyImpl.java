package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* compiled from: LazyJVM.kt */
/* loaded from: classes3.dex */
final class SafePublicationLazyImpl<T> implements f<T>, Serializable {
    public static final a Companion = new a(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    /* renamed from: final  reason: not valid java name */
    private final Object f0final;
    private volatile kotlin.jvm.b.a<? extends T> initializer;

    /* compiled from: LazyJVM.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    public SafePublicationLazyImpl(kotlin.jvm.b.a<? extends T> initializer) {
        kotlin.jvm.internal.s.h(initializer, "initializer");
        this.initializer = initializer;
        r rVar = r.a;
        this._value = rVar;
        this.f0final = rVar;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.f
    public T getValue() {
        T t = (T) this._value;
        r rVar = r.a;
        if (t != rVar) {
            return t;
        }
        kotlin.jvm.b.a<? extends T> aVar = this.initializer;
        if (aVar != null) {
            T invoke = aVar.invoke();
            if (valueUpdater.compareAndSet(this, rVar, invoke)) {
                this.initializer = null;
                return invoke;
            }
        }
        return (T) this._value;
    }

    public boolean isInitialized() {
        return this._value != r.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
